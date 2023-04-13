using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KNNproject
{
    internal class Positions
    {
        Pos[] ps = new Pos[100];
        int index=0;
        public void setPos(Pos pss)
        {
            ps[index++] = pss;
        }
        public Pos[] getPos()
        {
            return ps;
        }
        public int getIndex()
        {
            return index;
        }
        public void setPos(int ind)
        {
            //ps[ind] = null;
        }
        public void clearPos()
        {
            for(int i=0; i < ps.Length; i++)
            {
                //ps[i] = null;
            }
            index = 0;
        }
    }
}
