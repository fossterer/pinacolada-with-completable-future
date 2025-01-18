# The Pragmatic Programmer - Chapter 6 Concurrency: The Bartender Implementation using Threads (Since Java1.0) vs CompletableFutures (Since Java8)

## How to use

1. Install Maven on your system, if it does not exist
2. Execute `mvn test`

## What to expect

Notice the lines that say *Bartender with Threads took* and *Bartender with CompletableFutures took*
Here's a sample complete output:

````log
2025-01-19 08:08:36.159 [main] INFO  com.fossterer.App - Bartender with Threads:
2025-01-19 08:08:36.170 [main] INFO  com.fossterer.App - Starting at 1737292116161 ms
2025-01-19 08:08:36.172 [Thread-1] INFO  com.fossterer.tasks.ATask - Starting task [1737292116172 ms]: com.fossterer.tasks.Task02OpenMix
2025-01-19 08:08:36.172 [Thread-2] INFO  com.fossterer.tasks.ATask - Starting task [1737292116172 ms]: com.fossterer.tasks.Task01OpenBlender
2025-01-19 08:08:36.173 [Thread-3] INFO  com.fossterer.tasks.ATask - Starting task [1737292116173 ms]: com.fossterer.tasks.Task04MeasureRum
2025-01-19 08:08:37.173 [Thread-1] DEBUG com.fossterer.tasks.ATask - Ending task [1737292117173 ms]: com.fossterer.tasks.Task02OpenMix
2025-01-19 08:08:37.173 [Thread-2] DEBUG com.fossterer.tasks.ATask - Ending task [1737292117173 ms]: com.fossterer.tasks.Task01OpenBlender
2025-01-19 08:08:37.176 [Thread-4] INFO  com.fossterer.tasks.ATask - Starting task [1737292117176 ms]: com.fossterer.tasks.Task03PutMixInBlender
2025-01-19 08:08:37.176 [Thread-5] INFO  com.fossterer.tasks.ATask - Starting task [1737292117176 ms]: com.fossterer.tasks.Task06AddTwoCupsIce
2025-01-19 08:08:39.177 [Thread-4] DEBUG com.fossterer.tasks.ATask - Ending task [1737292119177 ms]: com.fossterer.tasks.Task03PutMixInBlender
2025-01-19 08:08:39.178 [Thread-5] DEBUG com.fossterer.tasks.ATask - Ending task [1737292119177 ms]: com.fossterer.tasks.Task06AddTwoCupsIce
2025-01-19 08:08:41.174 [Thread-3] DEBUG com.fossterer.tasks.ATask - Ending task [1737292121173 ms]: com.fossterer.tasks.Task04MeasureRum
2025-01-19 08:08:41.177 [Thread-6] INFO  com.fossterer.tasks.ATask - Starting task [1737292121177 ms]: com.fossterer.tasks.Task05PourInRum
2025-01-19 08:08:42.179 [Thread-6] DEBUG com.fossterer.tasks.ATask - Ending task [1737292122179 ms]: com.fossterer.tasks.Task05PourInRum
2025-01-19 08:08:42.181 [Thread-7] INFO  com.fossterer.tasks.ATask - Starting task [1737292122181 ms]: com.fossterer.tasks.Task07CloseBlender
2025-01-19 08:08:42.181 [Thread-8] INFO  com.fossterer.tasks.ATask - Starting task [1737292122181 ms]: com.fossterer.tasks.Task10GetGlasses
2025-01-19 08:08:42.182 [Thread-9] INFO  com.fossterer.tasks.ATask - Starting task [1737292122182 ms]: com.fossterer.tasks.Task11GetPinkUmbrellas
2025-01-19 08:08:43.182 [Thread-7] DEBUG com.fossterer.tasks.ATask - Ending task [1737292123182 ms]: com.fossterer.tasks.Task07CloseBlender
2025-01-19 08:08:43.186 [Thread-10] INFO  com.fossterer.tasks.ATask - Starting task [1737292123185 ms]: com.fossterer.tasks.Task08Blend
2025-01-19 08:08:44.183 [Thread-8] DEBUG com.fossterer.tasks.ATask - Ending task [1737292124182 ms]: com.fossterer.tasks.Task10GetGlasses
2025-01-19 08:08:44.183 [Thread-9] DEBUG com.fossterer.tasks.ATask - Ending task [1737292124183 ms]: com.fossterer.tasks.Task11GetPinkUmbrellas
2025-01-19 08:08:53.187 [Thread-10] DEBUG com.fossterer.tasks.ATask - Ending task [1737292133187 ms]: com.fossterer.tasks.Task08Blend
2025-01-19 08:08:53.190 [Thread-11] INFO  com.fossterer.tasks.ATask - Starting task [1737292133189 ms]: com.fossterer.tasks.Task09OpenBlender
2025-01-19 08:08:54.191 [Thread-11] DEBUG com.fossterer.tasks.ATask - Ending task [1737292134191 ms]: com.fossterer.tasks.Task09OpenBlender
2025-01-19 08:08:54.193 [Thread-12] INFO  com.fossterer.tasks.ATask - Starting task [1737292134193 ms]: com.fossterer.tasks.Task12Serve
2025-01-19 08:08:55.194 [Thread-12] DEBUG com.fossterer.tasks.ATask - Ending task [1737292135194 ms]: com.fossterer.tasks.Task12Serve
2025-01-19 08:08:55.195 [main] INFO  com.fossterer.App - Ending at 1737292135195 ms
2025-01-19 08:08:55.196 [main] INFO  com.fossterer.App - Bartender with Threads took 19034 ms
2025-01-19 08:08:55.196 [main] INFO  com.fossterer.App - 
2025-01-19 08:08:55.197 [main] INFO  com.fossterer.App - Bartender with CompletableFutures:
2025-01-19 08:08:55.197 [main] INFO  com.fossterer.App - Starting at 1737292135197 ms
2025-01-19 08:08:55.203 [ForkJoinPool.commonPool-worker-1] INFO  com.fossterer.tasks.ATask - Starting task [1737292135203 ms]: com.fossterer.tasks.Task02OpenMix
2025-01-19 08:08:55.203 [ForkJoinPool.commonPool-worker-2] INFO  com.fossterer.tasks.ATask - Starting task [1737292135203 ms]: com.fossterer.tasks.Task01OpenBlender
2025-01-19 08:08:55.204 [ForkJoinPool.commonPool-worker-3] INFO  com.fossterer.tasks.ATask - Starting task [1737292135204 ms]: com.fossterer.tasks.Task04MeasureRum
2025-01-19 08:08:55.204 [ForkJoinPool.commonPool-worker-4] INFO  com.fossterer.tasks.ATask - Starting task [1737292135204 ms]: com.fossterer.tasks.Task10GetGlasses
2025-01-19 08:08:55.204 [ForkJoinPool.commonPool-worker-5] INFO  com.fossterer.tasks.ATask - Starting task [1737292135204 ms]: com.fossterer.tasks.Task11GetPinkUmbrellas
2025-01-19 08:08:56.204 [ForkJoinPool.commonPool-worker-1] DEBUG com.fossterer.tasks.ATask - Ending task [1737292136204 ms]: com.fossterer.tasks.Task02OpenMix
2025-01-19 08:08:56.204 [ForkJoinPool.commonPool-worker-2] DEBUG com.fossterer.tasks.ATask - Ending task [1737292136204 ms]: com.fossterer.tasks.Task01OpenBlender
2025-01-19 08:08:56.206 [ForkJoinPool.commonPool-worker-2] INFO  com.fossterer.tasks.ATask - Starting task [1737292136206 ms]: com.fossterer.tasks.Task03PutMixInBlender
2025-01-19 08:08:56.206 [ForkJoinPool.commonPool-worker-1] INFO  com.fossterer.tasks.ATask - Starting task [1737292136206 ms]: com.fossterer.tasks.Task06AddTwoCupsIce
2025-01-19 08:08:57.205 [ForkJoinPool.commonPool-worker-5] DEBUG com.fossterer.tasks.ATask - Ending task [1737292137205 ms]: com.fossterer.tasks.Task11GetPinkUmbrellas
2025-01-19 08:08:57.205 [ForkJoinPool.commonPool-worker-4] DEBUG com.fossterer.tasks.ATask - Ending task [1737292137205 ms]: com.fossterer.tasks.Task10GetGlasses
2025-01-19 08:08:58.207 [ForkJoinPool.commonPool-worker-2] DEBUG com.fossterer.tasks.ATask - Ending task [1737292138206 ms]: com.fossterer.tasks.Task03PutMixInBlender
2025-01-19 08:08:58.208 [ForkJoinPool.commonPool-worker-1] DEBUG com.fossterer.tasks.ATask - Ending task [1737292138208 ms]: com.fossterer.tasks.Task06AddTwoCupsIce
2025-01-19 08:09:00.205 [ForkJoinPool.commonPool-worker-3] DEBUG com.fossterer.tasks.ATask - Ending task [1737292140204 ms]: com.fossterer.tasks.Task04MeasureRum
2025-01-19 08:09:00.206 [ForkJoinPool.commonPool-worker-3] INFO  com.fossterer.tasks.ATask - Starting task [1737292140205 ms]: com.fossterer.tasks.Task05PourInRum
2025-01-19 08:09:01.206 [ForkJoinPool.commonPool-worker-3] DEBUG com.fossterer.tasks.ATask - Ending task [1737292141206 ms]: com.fossterer.tasks.Task05PourInRum
2025-01-19 08:09:01.207 [ForkJoinPool.commonPool-worker-3] INFO  com.fossterer.tasks.ATask - Starting task [1737292141207 ms]: com.fossterer.tasks.Task07CloseBlender
2025-01-19 08:09:02.208 [ForkJoinPool.commonPool-worker-3] DEBUG com.fossterer.tasks.ATask - Ending task [1737292142208 ms]: com.fossterer.tasks.Task07CloseBlender
2025-01-19 08:09:02.209 [ForkJoinPool.commonPool-worker-3] INFO  com.fossterer.tasks.ATask - Starting task [1737292142209 ms]: com.fossterer.tasks.Task08Blend
2025-01-19 08:09:12.210 [ForkJoinPool.commonPool-worker-3] DEBUG com.fossterer.tasks.ATask - Ending task [1737292152210 ms]: com.fossterer.tasks.Task08Blend
2025-01-19 08:09:12.210 [ForkJoinPool.commonPool-worker-3] INFO  com.fossterer.tasks.ATask - Starting task [1737292152210 ms]: com.fossterer.tasks.Task09OpenBlender
2025-01-19 08:09:13.211 [ForkJoinPool.commonPool-worker-3] DEBUG com.fossterer.tasks.ATask - Ending task [1737292153211 ms]: com.fossterer.tasks.Task09OpenBlender
2025-01-19 08:09:13.212 [ForkJoinPool.commonPool-worker-3] INFO  com.fossterer.tasks.ATask - Starting task [1737292153212 ms]: com.fossterer.tasks.Task12Serve
2025-01-19 08:09:14.213 [ForkJoinPool.commonPool-worker-3] DEBUG com.fossterer.tasks.ATask - Ending task [1737292154213 ms]: com.fossterer.tasks.Task12Serve
2025-01-19 08:09:14.213 [main] INFO  com.fossterer.App - Ending at 1737292154213 ms
2025-01-19 08:09:14.214 [main] INFO  com.fossterer.App - Bartender with CompletableFutures took 19016 ms
````

## What does this mean

See LinkedIn