package com.fossterer.bartenders;

import java.util.concurrent.CompletableFuture;

import com.fossterer.tasks.Task01OpenBlender;
import com.fossterer.tasks.Task02OpenMix;
import com.fossterer.tasks.Task03PutMixInBlender;
import com.fossterer.tasks.Task04MeasureRum;
import com.fossterer.tasks.Task05PourInRum;
import com.fossterer.tasks.Task06AddTwoCupsIce;
import com.fossterer.tasks.Task07CloseBlender;
import com.fossterer.tasks.Task08Blend;
import com.fossterer.tasks.Task09OpenBlender;
import com.fossterer.tasks.Task10GetGlasses;
import com.fossterer.tasks.Task11GetPinkUmbrellas;
import com.fossterer.tasks.Task12Serve;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Bartender that operates
 * using {@link CompletableFuture}s
 */
public class BartenderWithCompletableFutures extends ABartender
{

	@Override
	public void servePinaColada()
	{
		// Start 1st stage of actions
		CompletableFuture<Void> task02Future = CompletableFuture.runAsync(new Task02OpenMix());
		CompletableFuture<Void> task01Future = CompletableFuture.runAsync(new Task01OpenBlender());
		CompletableFuture<Void> task04Future = CompletableFuture.runAsync(new Task04MeasureRum());

		// Start 2nd stage of actions
		CompletableFuture<Void> task03Future = CompletableFuture.allOf(task02Future, task01Future)
				.thenRunAsync(new Task03PutMixInBlender());
		CompletableFuture<Void> task06Future = task01Future.thenRunAsync(new Task06AddTwoCupsIce());
		CompletableFuture<Void> task05Future = CompletableFuture.allOf(task01Future, task04Future)
				.thenRunAsync(new Task05PourInRum());

		// Start 3rd stage of actions
		CompletableFuture<Void> task07Future = CompletableFuture.allOf(task03Future, task06Future, task05Future)
				.thenRunAsync(new Task07CloseBlender());

		// Start 4th stage of actions
		CompletableFuture<Void> task10Future = CompletableFuture.runAsync(new Task10GetGlasses());
		CompletableFuture<Void> task11Future = CompletableFuture.runAsync(new Task11GetPinkUmbrellas());
		CompletableFuture<Void> task08Future = task07Future.thenRunAsync(new Task08Blend());

		// Start 5th stage of actions
		CompletableFuture<Void> task09Future = task08Future.thenRunAsync(new Task09OpenBlender());

		// Start 6th stage of actions
		CompletableFuture<Void> task12Future = CompletableFuture.allOf(task10Future, task11Future, task09Future)
				.thenRunAsync(new Task12Serve());

		// Conclude
		task12Future.join();
	}

}
