;; much of what follows, at least initially, owes
;; a great deal to
;; https://github.com/gilesc/stanford-corenlp/blob/master/src/corenlp.clj

(ns clj-textrank.core
  (:import (java.io StringReader)
           (edu.stanford.nlp.process PTBTokenizer DocumentPreprocessor)
           (edu.stanford.nlp.ling Word))
  (:require [clojure.data.json :as json]))

(defonce d 0.85)

(defn tokenize [s]
  (.tokenize
   (PTBTokenizer/newPTBTokenizer
    (StringReader. s))))

(defn parse-text [t]
  "Splits a text into a sequence of sentences
   represented as sequences of Words."
  (let [r (StringReader. t)]
    (map #(vec (map str %))
         (iterator-seq
          (.iterator
           (DocumentPreprocessor. r))))))

(def overlap
  ;; overlap takes a set of two sets
  ;; and memoizes their intersection
  (memoize (fn [s]
             (clojure.set/intersection (first s) (second s)))))

(defn score [ws]
  (fn [s]
    (+ (- 1 d)
       (* d (reduce #(+ %1 (/ (count (overlap #{s %2}))
                              (+ (Math/log (count s))
                                 (Math/log (count %2)))))
                    0
                    (disj ws s))))))

(defn rank [text]
  (let [msgs (parse-text text)
        sets (map set msgs)
        scorer (score (set sets))
        scored (reduce #(assoc %1 %2 (scorer (set %2)))
                       {}
                       msgs)
        sorted (sort-by val > scored)]
   sorted))

