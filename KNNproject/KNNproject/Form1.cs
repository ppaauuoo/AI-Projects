namespace KNNproject
{
    public partial class Form1 : Form
    {
        Positions pss = new Positions();
        Random rand = new Random();
        
        public Form1()
        {
            InitializeComponent();
        } 

        private int stateChecker(Color c)
        {
            if (c == Color.ForestGreen)
            {
                return 1;
            }
            else if (c == Color.Maroon)
            {
                return 2;
            }
            else
            {
                return 0;
            }
        }
        
        private int zoomEffect(int intk)
        {
            if(intk >= 40){
                return 0;
            }else if(intk >= 30)
            {
                return 5;
            }else if(intk >= 20)
            {
                return 10;
            }
            else
            {
                return 15;
            }
        }
        private void genDot(int intk,Color c,int size)
            {

            int state = stateChecker(c);
            


            for (int i = 0; i < intk; i++)
                {
                    PictureBox dot = new PictureBox();
                dot.Height = size;
                    dot.Width = size;
                    dot.BackColor = c;
                
                    int x = rand.Next(size, 480-size);
                    int y = rand.Next(size, 640-size);
                    dot.Location = new Point(x, y);
                    Pos ps = new Pos(x, y, state);
                
                    pss.setPos(ps);
               
                   
                    panel1.Controls.Add(dot);
                }
            }

        private void clearDot()
        {
            panel1.Controls.Clear();
            pss.clearPos();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int intsize = 0,dotsize=0;
            try
            {
                string size = textBox1.Text;
                intsize = int.Parse(size);
            }
            catch (Exception)
            {
                MessageBox.Show("Please type something.");
                return;
            }
            clearDot();
            
        try
        {
            dotsize = 10 + zoomEffect(intsize);
            genDot(intsize, Color.ForestGreen, dotsize);
            genDot(intsize, Color.Maroon, dotsize);
            genDot(1, Color.Magenta, dotsize);
            }
            catch (Exception)
            {
                MessageBox.Show("Please try again with lesser size.");
                textBox1.Text = "";
                return;
            }
        }

        private int getX1Y1(Pos[] pos)
        {
            int temp=0;
            for (int i = 0; i < pss.getIndex(); i++)
            {
                int restate = pos[i].getState();
                if (restate == 0) {
                
                    temp = i;
                }
            }
            return temp;
        }
        
        private double[] getCalculatedValue(Pos[] pos,int temp,int x1,int y1)
        {
            double[] varray = new double[pss.getIndex() - 1];
            for (int i = 0; i < pss.getIndex(); i++)
            {
                if (i != temp)
                {
                    double reval = Math.Sqrt(Math.Pow(x1 - pos[i].getX(), 2) + Math.Pow(y1 - pos[i].getY(), 2));
                    varray[i] = reval;
                }
            }
            return varray;
        }

        private string colorSepration(Pos pos)
        {
            if (pos.getState() == 1)
            {
                return "Green";
            }
            else
            {
                return "Red";
            }
        }
        private string colorChecker(Pos[] poss,int intk)
        {
            
            int G = 0, R = 0;

            for (int i = 0; i < intk; i++)
            {
                if (poss[i].getState() == 1)
                {
                    G += 1;
                }
                else if (poss[i].getState() == 2)
                {
                    R += 1;
                }

            }
            if (G > R)
            {
                return "Is a Green";
            }
            else
            {
                return "Is a Red";
            }
        }

        private void showValue(Double[] varray, Pos[] poss)
        {
            string k = textBox2.Text;
            int intk = int.Parse(k);
            
            string outp = "";

            for (int i = 0; i < pss.getIndex() - 1; i++)
            {
                if (i == intk)
                {
                    outp += "~ ~ ~ ~\n";
                }
                outp += varray[i].ToString("0.00");
                outp += " : " + colorSepration(poss[i]);
                outp += "\n";
            }
            label1.Text = outp;
            label2.Text = colorChecker(poss, intk);
            if (intk % 2 == 0)
            {
                MessageBox.Show("Result might be incorrect because K is even.");
            }


        }
        private void button2_Click(object sender, EventArgs e) { 
        
            Pos [] poss = pss.getPos();
            int temp = 0,x1=0,y1=0;
            try{
                temp = getX1Y1(poss);
                x1 = poss[temp].getX();
                y1 = poss[temp].getY();
            }
            catch (Exception)
            {
                MessageBox.Show("Please generate the value.");
                textBox2.Text = "";
                return;
            }

            double[] varray = getCalculatedValue(poss, temp, x1, y1);

            Array.Sort(varray, poss);
            try
            {
                showValue(varray, poss);
            }
            catch (Exception) {
                MessageBox.Show("Please try again with lesser K.");
                textBox2.Text = "";
                return;
            }

        }

        

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }
    }
}