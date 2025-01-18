package com.fossterer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fossterer.bartenders.BartenderWithCompletableFutures;
import com.fossterer.bartenders.BartenderWithThreads;

/**
 * Hello world!
 *
 */
public class App
{
	public static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Hi");
		runBartenderWithCompletableFutures();
		logger.info("");
		runBartenderWithThreads();
	}

	private static void runBartenderWithThreads()
	{
		logger.info("Bartender with CompletableFutures:");

		long startTime = System.currentTimeMillis();
		logger.info("Starting at {} ms", startTime);

		BartenderWithCompletableFutures bartenderWithCompletableFutures = new BartenderWithCompletableFutures();
		bartenderWithCompletableFutures.servePinaColada();

		long endTime = System.currentTimeMillis();
		logger.info("Ending at {} ms", endTime);

		logger.info("Bartender with CompletableFutures took {} ms", endTime - startTime);
	}

	private static void runBartenderWithCompletableFutures() throws InterruptedException
	{
		logger.info("Bartender with Threads:");

		long startTime = System.currentTimeMillis();
		logger.info("Starting at {} ms", startTime);

		BartenderWithThreads bartenderWithThreads = new BartenderWithThreads();
		bartenderWithThreads.servePinaColada();

		long endTime = System.currentTimeMillis();
		logger.info("Ending at {} ms", endTime);

		logger.info("Bartender with Threads took {} ms", endTime - startTime);
	}
}
