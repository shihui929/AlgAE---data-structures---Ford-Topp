package edu.odu.cs.cs361.animations;


import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import edu.odu.cs.AlgAE.Server.MenuFunction;
import edu.odu.cs.AlgAE.Server.Animations.LocalJavaAnimation;
import edu.odu.cs.AlgAE.Server.MemoryModel.Component;
import edu.odu.cs.AlgAE.Server.MemoryModel.Connection;
import edu.odu.cs.AlgAE.Server.Rendering.Renderer;
import edu.odu.cs.AlgAE.Server.Utilities.Index;
import edu.odu.cs.cs361.animations.Queues.Queue_via_Array;

public class QViaArrayDemo extends LocalJavaAnimation {

	public class AQueueRenderer implements Renderer<Queue_via_Array> {

		@Override
		public Color getColor(Queue_via_Array obj) {
			return null;
		}

		@Override
		public List<Component> getComponents(Queue_via_Array q) {
			LinkedList<Component> comps = new LinkedList<Component>();
			comps.add (new Component(new Index(q.start, q.array), "start"));
			comps.add (new Component(new Index(q.stop, q.array), "stop"));
			comps.add (new Component(q.theSize, "theSize"));
			comps.add (new Component(q.array, "array"));
			return comps;
		}

		@Override
		public List<Connection> getConnections(Queue_via_Array obj) {
			return new LinkedList<Connection>();
		}

		@Override
		public int getMaxComponentsPerRow(Queue_via_Array obj) {
			return 3;
		}

		@Override
		public String getValue(Queue_via_Array obj) {
			return "";
		}

	}





    private LocalJavaAnimation self;
	
	public QViaArrayDemo() {
		super("Queue Implementations");
		self = this;
	}

	@Override
	public String about() {
		return "Demonstration of queue implementation,\n" +
				"prepared for CS 361, Advanced Data Structures and Algorithms\n" +
				"Summer 2011";
	}

	
	
	@Override
	public void buildMenu() {
		
		
		
		registerStartingAction(new MenuFunction() {

			@Override
			public void selected() {
				//getAnimator().setSpeed(30);
				getMemoryModel().render(Queue_via_Array.class, new AQueueRenderer());
				
				new Queues().arrayQDemo(self);
			}
			
		});
		
		
	}
	
	
	
	public static void main (String[] args) {
		QViaArrayDemo demo = new QViaArrayDemo();
		demo.runAsMain();
	}

}
