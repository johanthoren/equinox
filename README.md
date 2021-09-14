# xyz.thoren/equinox

A Clojure(Script) library designed to calculate equinoxes and solstices for a
given year. The accuracy is within a few minutes.

## Usage

[![Clojars Project](https://img.shields.io/clojars/v/xyz.thoren/equinox.svg)](https://clojars.org/xyz.thoren/equinox)

Require:

``` clojure
(:require [xyz.thoren.equinox :as e])
```

Examples:

``` clojure
(e/march-equinox 2021)
;;=> {:year 2021, :month 3, :day 20, :hour 9, :minute 35, :second 36}

(e/june-solstice 2021)
;;=> {:year 2021, :month 6, :day 21, :hour 3, :minute 24, :second 13}

(e/september-equinox 2021)
;;=> {:year 2021, :month 9, :day 22, :hour 19, :minute 11, :second 14}

(e/december-solstice 2021)
;;=> {:year 2021, :month 12, :day 21, :hour 15, :minute 46, :second 8}
```

## License

```
ISC License

Copyright (c) 2021, Johan Thorén

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted, provided that the above
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
```
