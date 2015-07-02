/*
   Copyright (c) 2015 Alexander 
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

import java.lang.Thread;
import java.lang.Runnable;

public abstract class ThreadObject implements Runnable {

	public ThreadObject() {
		this.thread = new Thread();
	}

	// ==========================================================================

	public void interrupt() {
		this.getThread().interrupt();
	}

	// ==========================================================================

	public void start() {
		this.getThread().start();
	}

	public static final String PROPERTY_THREAD = "thread";

	private Thread thread;

	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Runnable value) {
		if (!this.thread.isAlive()) {
			Thread oldValue = this.thread;
			this.thread = new Thread((java.lang.Runnable) value);
		}
	}

	public ThreadObject withThread(Runnable value) {
		setThread(value);
		return this;
	}

	// ==========================================================================

	public void setThread(Thread value) {
		if (this.thread != value) {
			Thread oldValue = this.thread;
			this.thread = value;
		}
	}

	public ThreadObject withThread(Thread value) {
		setThread(value);
		return this;
	}

}
