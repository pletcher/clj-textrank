# clj-textrank

A Clojure library implementing [TextRank](http://web.eecs.umich.edu/~mihalcea/papers/mihalcea.emnlp04.pdf) using Stanford [CoreNLP](http://nlp.stanford.edu/software/corenlp.shtml).

## Usage

```clojure
(use 'clj-textrank.core)

(rank "The story so far:
       In the beginning the Universe was created.
       This has made a lot of people very angry
       and been widely regarded as a bad move.")

```


## License

Copyright © 2015 @pletcher

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
