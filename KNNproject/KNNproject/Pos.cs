using System;

namespace KNNproject
{
	internal class Pos
	{
		private int x, y, state;
		//public Pos() { }
		public Pos(int x, int y, int state)
		{
			this.x = x;
			this.y = y;
			this.state = state;
		}
		public int getX()
		{
			return x;
		}
		public int getY()
		{
			return y;
		}
		public int getState()
		{
			return state;
		}
	}
}

