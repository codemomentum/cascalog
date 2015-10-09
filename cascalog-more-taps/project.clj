(def ROOT-DIR (subs *file* 0 (- (count *file*) (count "project.clj"))))
(def HADOOP-VERSION (-> ROOT-DIR (str "/../HADOOP-VERSION") slurp))
(def VERSION "3.0.0-flink-SNAPSHOT")

(defproject cascalog/cascalog-more-taps VERSION
  :description "More taps for Cascalog"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :javac-options ["-target" "1.7" "-source" "1.7"]
  :aot :all
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :jar-exclusions [#"\.java$"]
  :repositories {"conjars.org" "http://conjars.org/repo"}
  :profiles {:1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :provided {:dependencies [[cascalog/cascalog-core ~VERSION]
                                       [org.apache.hadoop/hadoop-client ~HADOOP-VERSION]]}
             :dev {:plugins [[lein-midje "3.1.3"]]
                   :dependencies
                   [[cascalog/midje-cascalog ~VERSION]
                    [hadoop-util "0.3.0"]]}})
