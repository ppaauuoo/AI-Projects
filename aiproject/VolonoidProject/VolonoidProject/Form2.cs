using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace VolonoidProject
{
    public partial class Form2 : Form
    {
        public Random rand = new Random();
        static int x, y;
        static int [] valx = new int[12];
        static int[] valy = new int[12];
        static int[] label = new int[12];
        SolidBrush red = new SolidBrush(Color.Red);
        SolidBrush blue = new SolidBrush(Color.Blue);
        SolidBrush green = new SolidBrush(Color.Green);
        //Rectangle [] rect = new Rectangle[6];
        //Eclipse [] eps = new Eclipse[6];
        Bitmap bitmap;
        Graphics g;
        public Form2()
        {
            InitializeComponent();
            bitmap = new Bitmap(pictureBox1.Width,pictureBox1.Height);
            g= Graphics.FromImage(bitmap);
            g.Clear(Color.White);
            pictureBox1.Image = bitmap;
            getValue();

        }

        private void button1_Click(object sender, EventArgs e)
        {

            getValue();
            
            getCalculatedValue();
            
            createShape();
            pictureBox1.Refresh();

        }

        
        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            
        }

        private void getValue()
        {

            g.Clear(Color.White);
            int k = 0;
            while (k < 12)
            {
                x = rand.Next(1, 19) * 10;
                y = rand.Next(1, 19) * 10;
                label[k] = 0;
                valx[k] = x;
                valy[k] = y;
                k++;
                x = rand.Next(1, 19) * 10;
                y = rand.Next(1, 19) * 10;
                label[k] = 1;
                valx[k] = x;
                valy[k] = y;
                k++;
            }
        }

        private void createShape()
        {
            int k = 0;
            int size = 5;
            while (k<12) {
                g.FillEllipse(red, valx[k], valy[k], size, size);
                k++;
                g.FillEllipse(blue, valx[k], valy[k], size, size);
                k++;
            }
        }

        private SolidBrush labelChecker(int k)
        {
            if (k == 0)
            {
                return new SolidBrush(Color.Maroon);
            }
            else if(k==1)
            {
                return new SolidBrush(Color.BlueViolet);
            }
            else
            {
                return green;
            }
        }
        private void getCalculatedValue()
        {
            double temp=0,reval=100;
            int revalpos=0,posx=0,posy=0;
            for (int k = 1; k < 200; k ++)
            {
                for (int i = 1; i <200; i ++)
                {
                    for (int j = 0; j < 12; j++)
                    {
                        temp = Math.Sqrt(Math.Pow(k - valx[j], 2) + Math.Pow(i - valy[j], 2));
                        if (reval > temp)
                        {
                            reval = temp;
                            revalpos = j;
                            posx = k;
                            posy = i;
                            //System.Console.WriteLine("dog"+bitmap.GetPixel(valx[revalpos], valy[revalpos]));

                        }
                    }

                    g.FillRectangle(labelChecker(label[revalpos]), posx, posy, 1, 1);
                    reval = 100;
                }

            }


        }


    }
}
