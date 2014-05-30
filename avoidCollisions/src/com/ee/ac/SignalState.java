package com.ee.ac;

public enum SignalState {

	RED {
		@Override
		public SignalState next() {
			// TODO Auto-generated method stub
			return YELLOW;
		}
	},
	GREEN {
		@Override
		public SignalState next() {
			// TODO Auto-generated method stub
			return RED;
		}
	},YELLOW {
		@Override
		public SignalState next() {
			// TODO Auto-generated method stub
			return DOUBLEYELLOW;
		}
	}, DOUBLEYELLOW {
		@Override
		public SignalState next() {
			// TODO Auto-generated method stub
			return GREEN;
		}
	};
	
	public abstract SignalState next();
}
