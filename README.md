This sample project configures maven with surefire to run a zohhak (plus junit) test in parallel mode. This will lead to a nasty NullPointerException...

Output of running "mvn clean test":

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
[DEBUG] boot classpath:  /Users/cpickl/.m2/repository/org/apache/maven/surefire/surefire-booter/2.19.1/surefire-booter-2.19.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/surefire/surefire-api/2.19.1/surefire-api-2.19.1.jar  /Users/cpickl/Desktop/zohhak_parallel_bug/target/test-classes  /Users/cpickl/Desktop/zohhak_parallel_bug/target/classes  /Users/cpickl/.m2/repository/junit/junit/4.12/junit-4.12.jar  /Users/cpickl/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar  /Users/cpickl/.m2/repository/com/googlecode/zohhak/zohhak/1.1.1/zohhak-1.1.1.jar  /Users/cpickl/.m2/repository/org/apache/commons/commons-lang3/3.1/commons-lang3-3.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/surefire/surefire-junit47/2.19.1/surefire-junit47-2.19.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/surefire/common-junit48/2.19.1/common-junit48-2.19.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/surefire/common-junit4/2.19.1/common-junit4-2.19.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/surefire/common-junit3/2.19.1/common-junit3-2.19.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/surefire/common-java5/2.19.1/common-java5-2.19.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/shared/maven-shared-utils/0.9/maven-shared-utils-0.9.jar  /Users/cpickl/.m2/repository/com/google/code/findbugs/jsr305/2.0.1/jsr305-2.0.1.jar  /Users/cpickl/.m2/repository/org/apache/maven/surefire/surefire-grouper/2.19.1/surefire-grouper-2.19.1.jar
[DEBUG] boot(compact) classpath:  surefire-booter-2.19.1.jar  surefire-api-2.19.1.jar  test-classes  classes  junit-4.12.jar  hamcrest-core-1.3.jar  zohhak-1.1.1.jar  commons-lang3-3.1.jar  surefire-junit47-2.19.1.jar  common-junit48-2.19.1.jar  common-junit4-2.19.1.jar  common-junit3-2.19.1.jar  common-java5-2.19.1.jar  maven-shared-utils-0.9.jar  jsr305-2.0.1.jar  surefire-grouper-2.19.1.jar
Forking command line: /bin/sh -c cd /Users/cpickl/Desktop/zohhak_parallel_bug && /Library/Java/JavaVirtualMachines/jdk1.8.0_102.jdk/Contents/Home/jre/bin/java -jar /Users/cpickl/Desktop/zohhak_parallel_bug/target/surefire/surefirebooter5962425686982851698.jar /Users/cpickl/Desktop/zohhak_parallel_bug/target/surefire/surefire3832748489260842829tmp /Users/cpickl/Desktop/zohhak_parallel_bug/target/surefire/surefire_05289073404940292895tmp
Running testMethod
Tests run: 0, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec - in testMethod

Results :

Tests run: 0, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.475 s
[INFO] Finished at: 2016-11-04T11:59:56+01:00
[INFO] Final Memory: 19M/619M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test (default-test) on project playground: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test failed: There was an error in the forked process
[ERROR] org.apache.maven.surefire.testset.TestSetFailedException: java.lang.NullPointerException
[ERROR] at org.apache.maven.surefire.common.junit4.JUnit4RunListener.rethrowAnyTestMechanismFailures(JUnit4RunListener.java:209)
[ERROR] at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.createRequestAndRun(JUnitCoreWrapper.java:138)
[ERROR] at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.executeEager(JUnitCoreWrapper.java:107)
[ERROR] at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:83)
[ERROR] at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:75)
[ERROR] at org.apache.maven.surefire.junitcore.JUnitCoreProvider.invoke(JUnitCoreProvider.java:161)
[ERROR] at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:290)
[ERROR] at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:242)
[ERROR] at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:121)
[ERROR] Caused by: java.lang.NullPointerException
[ERROR] at org.apache.maven.surefire.junitcore.ConcurrentRunListener.testStarting(ConcurrentRunListener.java:135)
[ERROR] at org.apache.maven.surefire.common.junit4.JUnit4RunListener.testStarted(JUnit4RunListener.java:91)
[ERROR] at org.junit.runner.notification.SynchronizedRunListener.testStarted(SynchronizedRunListener.java:49)
[ERROR] at org.junit.runner.notification.RunNotifier$3.notifyListener(RunNotifier.java:121)
[ERROR] at org.junit.runner.notification.RunNotifier$SafeNotifier.run(RunNotifier.java:72)
[ERROR] at org.junit.runner.notification.RunNotifier.fireTestStarted(RunNotifier.java:118)
[ERROR] at org.apache.maven.surefire.common.junit4.Notifier.fireTestStarted(Notifier.java:100)
[ERROR] at org.junit.internal.runners.model.EachTestNotifier.fireTestStarted(EachTestNotifier.java:42)
[ERROR] at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:323)
[ERROR] at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
[ERROR] at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
[ERROR] at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
[ERROR] at org.apache.maven.surefire.junitcore.pc.Scheduler$1.run(Scheduler.java:393)
[ERROR] at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
[ERROR] at java.util.concurrent.FutureTask.run(FutureTask.java:266)
[ERROR] at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
[ERROR] at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
[ERROR] at java.lang.Thread.run(Thread.java:745)
[ERROR] -> [Help 1]
org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test (default-test) on project playground: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test failed: There was an error in the forked process
org.apache.maven.surefire.testset.TestSetFailedException: java.lang.NullPointerException
    at org.apache.maven.surefire.common.junit4.JUnit4RunListener.rethrowAnyTestMechanismFailures(JUnit4RunListener.java:209)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.createRequestAndRun(JUnitCoreWrapper.java:138)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.executeEager(JUnitCoreWrapper.java:107)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:83)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:75)
    at org.apache.maven.surefire.junitcore.JUnitCoreProvider.invoke(JUnitCoreProvider.java:161)
    at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:290)
    at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:242)
    at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:121)
Caused by: java.lang.NullPointerException
    at org.apache.maven.surefire.junitcore.ConcurrentRunListener.testStarting(ConcurrentRunListener.java:135)
    at org.apache.maven.surefire.common.junit4.JUnit4RunListener.testStarted(JUnit4RunListener.java:91)
    at org.junit.runner.notification.SynchronizedRunListener.testStarted(SynchronizedRunListener.java:49)
    at org.junit.runner.notification.RunNotifier$3.notifyListener(RunNotifier.java:121)
    at org.junit.runner.notification.RunNotifier$SafeNotifier.run(RunNotifier.java:72)
    at org.junit.runner.notification.RunNotifier.fireTestStarted(RunNotifier.java:118)
    at org.apache.maven.surefire.common.junit4.Notifier.fireTestStarted(Notifier.java:100)
    at org.junit.internal.runners.model.EachTestNotifier.fireTestStarted(EachTestNotifier.java:42)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:323)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    at org.apache.maven.surefire.junitcore.pc.Scheduler$1.run(Scheduler.java:393)
    at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
    at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
    at java.lang.Thread.run(Thread.java:745)

    at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:212)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
    at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
    at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
    at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
    at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
    at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
Caused by: org.apache.maven.plugin.PluginExecutionException: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test failed: There was an error in the forked process
org.apache.maven.surefire.testset.TestSetFailedException: java.lang.NullPointerException
    at org.apache.maven.surefire.common.junit4.JUnit4RunListener.rethrowAnyTestMechanismFailures(JUnit4RunListener.java:209)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.createRequestAndRun(JUnitCoreWrapper.java:138)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.executeEager(JUnitCoreWrapper.java:107)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:83)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:75)
    at org.apache.maven.surefire.junitcore.JUnitCoreProvider.invoke(JUnitCoreProvider.java:161)
    at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:290)
    at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:242)
    at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:121)
Caused by: java.lang.NullPointerException
    at org.apache.maven.surefire.junitcore.ConcurrentRunListener.testStarting(ConcurrentRunListener.java:135)
    at org.apache.maven.surefire.common.junit4.JUnit4RunListener.testStarted(JUnit4RunListener.java:91)
    at org.junit.runner.notification.SynchronizedRunListener.testStarted(SynchronizedRunListener.java:49)
    at org.junit.runner.notification.RunNotifier$3.notifyListener(RunNotifier.java:121)
    at org.junit.runner.notification.RunNotifier$SafeNotifier.run(RunNotifier.java:72)
    at org.junit.runner.notification.RunNotifier.fireTestStarted(RunNotifier.java:118)
    at org.apache.maven.surefire.common.junit4.Notifier.fireTestStarted(Notifier.java:100)
    at org.junit.internal.runners.model.EachTestNotifier.fireTestStarted(EachTestNotifier.java:42)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:323)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    at org.apache.maven.surefire.junitcore.pc.Scheduler$1.run(Scheduler.java:393)
    at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
    at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
    at java.lang.Thread.run(Thread.java:745)

    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:145)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
    ... 20 more
Caused by: java.lang.RuntimeException: There was an error in the forked process
org.apache.maven.surefire.testset.TestSetFailedException: java.lang.NullPointerException
    at org.apache.maven.surefire.common.junit4.JUnit4RunListener.rethrowAnyTestMechanismFailures(JUnit4RunListener.java:209)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.createRequestAndRun(JUnitCoreWrapper.java:138)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.executeEager(JUnitCoreWrapper.java:107)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:83)
    at org.apache.maven.surefire.junitcore.JUnitCoreWrapper.execute(JUnitCoreWrapper.java:75)
    at org.apache.maven.surefire.junitcore.JUnitCoreProvider.invoke(JUnitCoreProvider.java:161)
    at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:290)
    at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:242)
    at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:121)
Caused by: java.lang.NullPointerException
    at org.apache.maven.surefire.junitcore.ConcurrentRunListener.testStarting(ConcurrentRunListener.java:135)
    at org.apache.maven.surefire.common.junit4.JUnit4RunListener.testStarted(JUnit4RunListener.java:91)
    at org.junit.runner.notification.SynchronizedRunListener.testStarted(SynchronizedRunListener.java:49)
    at org.junit.runner.notification.RunNotifier$3.notifyListener(RunNotifier.java:121)
    at org.junit.runner.notification.RunNotifier$SafeNotifier.run(RunNotifier.java:72)
    at org.junit.runner.notification.RunNotifier.fireTestStarted(RunNotifier.java:118)
    at org.apache.maven.surefire.common.junit4.Notifier.fireTestStarted(Notifier.java:100)
    at org.junit.internal.runners.model.EachTestNotifier.fireTestStarted(EachTestNotifier.java:42)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:323)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    at org.apache.maven.surefire.junitcore.pc.Scheduler$1.run(Scheduler.java:393)
    at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
    at java.util.concurrent.FutureTask.run(FutureTask.java:266)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
    at java.lang.Thread.run(Thread.java:745)

    at org.apache.maven.plugin.surefire.booterclient.ForkStarter.fork(ForkStarter.java:584)
    at org.apache.maven.plugin.surefire.booterclient.ForkStarter.fork(ForkStarter.java:460)
    at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run(ForkStarter.java:229)
    at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run(ForkStarter.java:201)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeProvider(AbstractSurefireMojo.java:1026)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeAfterPreconditionsChecked(AbstractSurefireMojo.java:862)
    at org.apache.maven.plugin.surefire.AbstractSurefireMojo.execute(AbstractSurefireMojo.java:755)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
    ... 21 more
[ERROR] 
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginExecutionException
```