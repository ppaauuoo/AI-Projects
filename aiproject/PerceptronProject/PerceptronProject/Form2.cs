using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PerceptronProject
{
    public partial class Form2 : Form
    {
        Bitmap bitmap;
        Graphics g;
        Random rand = new Random();
        int[] label = new int[4];
        int[] weight = { 1, 1, 1, 1 };
        int[] valx = { 0,0,190,190 };
        int[] valy = { 0, 190, 0, 190 };
        int[] def = {0,0,0};
        int[] temp = new int[5];
        SolidBrush red = new SolidBrush(Color.Red);
        SolidBrush blue = new SolidBrush(Color.Blue);
        SolidBrush green = new SolidBrush(Color.Green);
        public Form2()
        {
            InitializeComponent();
            bitmap = new Bitmap(pictureBox1.Width, pictureBox1.Height);
            g = Graphics.FromImage(bitmap);
            g.Clear(Color.White);
            pictureBox1.Image = bitmap;

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }
        
        private int labelChecker(int l)
        {
            if (l >= 0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
        
        
        private void resetCounter()
        {
            for(int i= 0; i < 4; i++)
            {
                temp[i] = -1;
            }
        }

        private void reset()
        {
            for (int i = 0; i < 3; i++)
            {
                def[i] = 0;
            }
        }
        
        private bool dupeChecker(int k)
        {
            for (int i = 0; i < 4; i++)
            {
                if (temp[i] == k)
                {
                    return true;
                }
            }
            return false;
        }

        private void setDef(int k)
        {
            def[0] += valx[k] * label[k];
            def[1] += valy[k] * label[k];
            def[2] += weight[k] * label[k];
        }
        private void process()
        {
            int count = 0, resul = 0, k = 0;
            reset();
            while (count<4) {
                
                k = rand.Next(0, 4);

                if (dupeChecker(k))
                    continue;

                resul = valx[k] * def[0] + valy[k] * def[1] + weight[k] * def[2];
                if (labelChecker(resul) == label[k])
                    temp[count++] = k;
                else {
                    setDef(k);
                    count = 0;
                    resetCounter();
                } 
                //System.Diagnostics.Debug.WriteLine(k+" "+count+" "+resul+" " + label[k]);
            }
            
;        }



        private void calculateShape()
        {
            SolidBrush col;
            int size = 10;
            int state;
            
            
            /*
            label[0] = state;
            col = colorChecker(state);
            g.FillEllipse(col, valx[0], valy[0], size, size);
            state *= -1;
            */
            for (int i = 0; i < 4; i++)
            {
                state = randColor();
                label[i] = state;
                col = colorChecker(state);
                g.FillEllipse(col, valx[i], valy[i], size, size);

            }
        }

        private void calculateLine()
        {
            Pen pen = new Pen(Color.Green);
            int b = def[1];
            if (b != 0)
            {
                int a = def[0];

                int c = def[2];
                int newX1 = 0;
                int newY1 = (-c - a * newX1) / b;

                int newX2 = 190;
                int newY2 = (-c - a * newX2) / b;

                Point p1 = new Point(newX1, newY1);
                Point p2 = new Point(newX2, newY2);

                g.DrawLine(pen, p1, p2);
            }
        }
        private void button1_Click(object sender, EventArgs e)
        {
            g.Clear(Color.White);
            
            calculateShape();

            process();

            calculateLine();
            
            pictureBox1.Refresh();
        }
        
        
        
        private SolidBrush colorChecker(int i)
        {
            
            if(i==1)
            {
                return red;
            }
            else
            {
                return blue;
            }
        }

        private int randColor()
        {

            if (rand.Next(0, 2) == 0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }
}
