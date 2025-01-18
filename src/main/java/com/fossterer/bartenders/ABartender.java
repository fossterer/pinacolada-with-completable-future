package com.fossterer.bartenders;

/**
 * The Pragmatic Programmer - Chapter 6 Concurrency: Bartenders are supposed to
 * "Serve Pina colada"
 */
public abstract class ABartender
{
	public abstract void servePinaColada() throws InterruptedException;
}
