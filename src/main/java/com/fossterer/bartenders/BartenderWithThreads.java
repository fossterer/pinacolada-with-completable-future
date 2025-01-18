package com.fossterer.bartenders;

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
 * using {@link Thread}s
 */
public class BartenderWithThreads extends ABartender
{

	@Override
	public void servePinaColada() throws InterruptedException
	{
		// Start 1st stage of actions
		Thread task02Thread = new Thread(new Task02OpenMix());
		task02Thread.start();
		Thread task01Thread = new Thread(new Task01OpenBlender());
		task01Thread.start();
		Thread task04Thread = new Thread(new Task04MeasureRum());
		task04Thread.start();
		
		// Start 2nd stage of actions
		task02Thread.join();
		task01Thread.join();
		Thread task03Thread = new Thread(new Task03PutMixInBlender());
		task03Thread.start();
		Thread task06Thread = new Thread(new Task06AddTwoCupsIce());
		task06Thread.start();
		
		task04Thread.join();
		Thread task05Thread = new Thread(new Task05PourInRum());
		task05Thread.start();
		
		// Start 3rd stage of actions
		task03Thread.join();
		task06Thread.join();
		task05Thread.join();
		Thread task07Thread = new Thread(new Task07CloseBlender());
		task07Thread.start();
		
		// Start 4th stage of actions
		Thread task10Thread = new Thread(new Task10GetGlasses());
		task10Thread.start();
		Thread task11Thread = new Thread(new Task11GetPinkUmbrellas());
		task11Thread.start();
		task07Thread.join();
		Thread task08Thread = new Thread(new Task08Blend());
		task08Thread.start();
		
		// Start 5th stage of actions
		task08Thread.join();
		Thread task09Thread = new Thread(new Task09OpenBlender());
		task09Thread.start();
		
		// Start 6th stage of actions
		task10Thread.join();
		task11Thread.join();
		task09Thread.join();
		Thread task12Thread = new Thread(new Task12Serve());
		task12Thread.start();
		
		// Conclude
		task12Thread.join();
	}

}
