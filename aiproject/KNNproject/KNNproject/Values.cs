using System;
namespace KNNproject
{
	internal class Values
	{
		Value[] vals = new Value[100];
		int index=0;
		public void setVal(Value val)
        {
			vals[index++] = val;
        }
		public Value [] getVal()
        {
			return vals;
        }
	}
}

