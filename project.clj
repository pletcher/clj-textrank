(defproject clj-textrank "0.1.0-SNAPSHOT"
  :description "Clojure TextRank"
  :url "https://github.com/pletcher/clj-textrank"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.json "0.2.6"]
                 [edu.stanford.nlp/stanford-corenlp "3.5.1"]
                 [edu.stanford.nlp/stanford-corenlp "3.5.1"
                  :classifier "models"]
                 [aysylu/loom "0.5.0"]]
  :main ^:skip-aot clj-textrank.core)
