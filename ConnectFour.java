// The "ConnectFour" class.
import java.awt.*;
import hsa.Console;
import java.awt.Color;

public class ConnectFour
{
    static Console c;           // The output console
    static String player1, player2;
    static int nameLength;

    // GAME

    public static void gameBoard ()
    {

	c.setColor (new Color (255, 255, 0));
	c.drawLine (25, 550, 90, 550);
	c.drawLine (25, 520, 90, 520);

	board ();

	Font ff = new Font ("Arial", Font.PLAIN, 20); // making a new font
	int first[] = new int [6];
	int second[] = new int [6];
	int third[] = new int [6];
	int fourth[] = new int [6];
	int fifth[] = new int [6];
	int sixth[] = new int [6];
	int seventh[] = new int [6];
	int firstCounter = 0;
	int secondCounter = 0;
	int thirdCounter = 0;
	int fourthCounter = 0;
	int fifthCounter = 0;
	int sixthCounter = 0;
	int seventhCounter = 0;
	int condition;
	int count = 0;


	int x = 1, z = 430, a = 430, b = 430, cc = 430, d = 430, e = 430, f = 430, t = 430;
	while (x != 0)
	{
	    c.setColor (new Color (0, 0, 0));

	    c.setFont (ff);
	    c.drawString ("Enter slot number: ", 25, 600);
	    c.drawString (player1, 25, 540);
	    c.drawString (player2, 615, 540);
	    int slot = c.getChar ();
	    if (slot == '1')
	    {
		if (z != -50)
		{

		    game (50, z, t);
		    if (t % 2 == 0)
		    {
			first [firstCounter] = 1;


		    }
		    else if (t % 2 != 0)
		    {
			first [firstCounter] = 2;
		    }

		    z = z - 80;
		    t++;
		    firstCounter++;
		}
	    }
	    else if (slot == '2')
	    {
		if (a != -50)
		{

		    game (130, a, t);
		    if (t % 2 == 0)
		    {
			second [secondCounter] = 1;

		    }
		    else if (t % 2 != 0)
		    {
			second [secondCounter] = 2;
		    }
		    a = a - 80;
		    t++;
		    secondCounter++;
		}
	    }
	    else if (slot == '3')
	    {
		if (b != -50)
		{


		    game (210, b, t);
		    if (t % 2 == 0)
		    {
			third [thirdCounter] = 1;
		    }
		    else if (t % 2 != 0)
		    {
			third [thirdCounter] = 2;
		    }
		    b = b - 80;
		    t++;
		    thirdCounter++;
		}
	    }
	    else if (slot == '4')
	    {
		if (cc != -50)
		{

		    game (290, cc, t);
		    if (t % 2 == 0)
		    {
			fourth [fourthCounter] = 1;
		    }
		    else if (t % 2 != 0)
		    {
			fourth [fourthCounter] = 2;
		    }
		    cc = cc - 80;
		    t++;
		    fourthCounter++;
		}
	    }
	    else if (slot == '5')
	    {
		if (d != -50)
		{

		    game (370, d, t);
		    if (t % 2 == 0)
		    {
			fifth [fifthCounter] = 1;
		    }
		    else if (t % 2 != 0)
		    {
			fifth [fifthCounter] = 2;
		    }
		    d = d - 80;
		    t++;
		    fifthCounter++;
		}
	    }
	    else if (slot == '6')
	    {
		if (e != -50)
		{

		    game (450, e, t);
		    if (t % 2 == 0)
		    {
			sixth [sixthCounter] = 1;
		    }
		    else if (t % 2 != 0)
		    {
			sixth [sixthCounter] = 2;
		    }
		    e = e - 80;
		    t++;
		    sixthCounter++;
		}
	    }
	    else if (slot == '7')
	    {
		if (f != -50)
		{

		    game (530, f, t);
		    if (t % 2 == 0)
		    {
			seventh [seventhCounter] = 1;
		    }
		    else if (t % 2 != 0)
		    {
			seventh [seventhCounter] = 2;
		    }
		    f = f - 80;
		    t++;
		    seventhCounter++;
		}
	    }
	    // Horizontal Checking
	    condition = win (first, second, third, fourth, fifth, sixth, seventh);
	    condition = win1 (first, second, third, fourth, fifth, sixth, seventh);
	    condition = win2 (first, second, third, fourth, fifth, sixth, seventh);
	    condition = win3 (first, second, third, fourth, fifth, sixth, seventh);
	    condition = win4 (first, second, third, fourth, fifth, sixth, seventh);
	    condition = win5 (first, second, third, fourth, fifth, sixth, seventh);

	    //Vertical Checking
	    condition = verticalWin (first, second, third, fourth, fifth, sixth, seventh);

	    //Diagonal Checking
	    condition = diagonalWin (first, second, third, fourth);
	    condition = diagonalWin1 (first, second, third, fourth);
	    condition = diagonalWin2 (first, second, third, fourth);

	    condition = diagonalWin3 (fourth, fifth, sixth, seventh);
	    condition = diagonalWin4 (fourth, fifth, sixth, seventh);
	    condition = diagonalWin5 (fourth, fifth, sixth, seventh);

	    condition = diagonalWin6 (second, third, fourth, fifth);
	    condition = diagonalWin7 (second, third, fourth, fifth);
	    condition = diagonalWin8 (second, third, fourth, fifth);

	    condition = diagonalWin9 (third, fourth, fifth, sixth);
	    condition = diagonalWin10 (third, fourth, fifth, sixth);
	    condition = diagonalWin11 (third, fourth, fifth, sixth);


	    //Draw
	    if (condition == 0 && count == 41)
		winningStatement (0);

	    count++;

	}
    }


    public static int diagonalWin (int first[], int second[], int third[], int fourth[])
    {
	//Trending upwards && downward
	int x = 0, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (first [x] == second [x + 1] && first [x] == third [x + 2] && first [x] == fourth [x + 3]
		&& first [x] == yellow && second [x + 1] == yellow && third [x + 2] == yellow && fourth [x + 3] == yellow)
	    condition++;

	//downward
	else if (first [x + 3] == second [x + 2] && first [x + 3] == third [x + 1] && first [x + 3] == fourth [x]
		&& first [x + 3] == yellow && second [x + 2] == yellow && third [x + 1] == yellow && fourth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (first [x] == second [x + 1] && first [x] == third [x + 2] && first [x] == fourth [x + 3]
		&& first [x] == red && second [x + 1] == red && third [x + 2] == red && fourth [x + 3] == red)
	    condition--;

	//downwards
	else if (first [x + 3] == second [x + 2] && first [x + 3] == third [x + 1] && first [x + 3] == fourth [x]
		&& first [x + 3] == red && second [x + 2] == red && third [x + 1] == red && fourth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin1 (int first[], int second[], int third[], int fourth[])
    {
	//Trending upwards
	int x = 1, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upwards
	if (first [x] == second [x + 1] && first [x] == third [x + 2] && first [x] == fourth [x + 3]
		&& first [x] == yellow && second [x + 1] == yellow && third [x + 2] == yellow && fourth [x + 3] == yellow)
	    condition++;

	//downward
	else if (first [x + 3] == second [x + 2] && first [x + 3] == third [x + 1] && first [x + 3] == fourth [x]
		&& first [x + 4] == yellow && second [x + 3] == yellow && third [x + 2] == yellow && fourth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (first [x] == second [x + 1] && first [x] == third [x + 2] && first [x] == fourth [x + 3]
		&& first [x] == red && second [x + 1] == red && third [x + 2] == red && fourth [x + 3] == red)
	    condition--;

	//downward
	else if (first [x + 3] == second [x + 2] && first [x + 3] == third [x + 1] && first [x + 3] == fourth [x]
		&& first [x + 3] == red && second [x + 2] == red && third [x + 1] == red && fourth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin2 (int first[], int second[], int third[], int fourth[])
    {
	//Trending upwards
	int x = 2, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upwards
	if (first [x] == second [x + 1] && first [x] == third [x + 2] && first [x] == fourth [x + 3]
		&& first [x] == yellow && second [x + 1] == yellow && third [x + 2] == yellow && fourth [x + 3] == yellow)
	    condition++;

	//downward
	else if (first [x + 3] == second [x + 2] && first [x + 3] == third [x + 1] && first [x + 3] == fourth [x]
		&& first [x + 3] == yellow && second [x + 2] == yellow && third [x + 1] == yellow && fourth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (first [x] == second [x + 1] && first [x] == third [x + 2] && first [x] == fourth [x + 3]
		&& first [x] == red && second [x + 1] == red && third [x + 2] == red && fourth [x + 3] == red)
	    condition--;

	//downward
	else if (first [x + 3] == second [x + 2] && first [x + 3] == third [x + 1] && first [x + 3] == fourth [x]
		&& first [x + 3] == red && second [x + 2] == red && third [x + 1] == red && fourth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin3 (int fourth[], int fifth[], int sixth[], int seventh[])
    {
	//Trending upwards && downward
	int x = 0, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (fourth [x] == fifth [x + 1] && fourth [x] == sixth [x + 2] && fourth [x] == seventh [x + 3]
		&& fourth [x] == yellow && fifth [x + 1] == yellow && sixth [x + 2] == yellow && seventh [x + 3] == yellow)
	    condition++;

	//downward
	else if (fourth [x + 3] == fifth [x + 2] && fourth [x + 3] == sixth [x + 1] && fourth [x + 3] == seventh [x]
		&& fourth [x + 3] == yellow && fifth [x + 2] == yellow && sixth [x + 1] == yellow && seventh [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (fourth [x] == fifth [x + 1] && fourth [x] == sixth [x + 2] && fourth [x] == seventh [x + 3]
		&& fourth [x] == red && fifth [x + 1] == red && sixth [x + 2] == red && seventh [x + 3] == red)
	    condition--;

	//downwards
	else if (fourth [x + 3] == fifth [x + 2] && fourth [x + 3] == sixth [x + 1] && fourth [x + 3] == seventh [x]
		&& fourth [x + 3] == red && fifth [x + 2] == red && sixth [x + 1] == red && seventh [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin4 (int fourth[], int fifth[], int sixth[], int seventh[])
    {
	//Trending upwards
	int x = 1, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upwards
	if (fourth [x] == fifth [x + 1] && fourth [x] == sixth [x + 2] && fourth [x] == seventh [x + 3]
		&& fourth [x] == yellow && fifth [x + 1] == yellow && sixth [x + 2] == yellow && seventh [x + 3] == yellow)
	    condition++;

	//downward
	else if (fourth [x + 3] == fifth [x + 2] && fourth [x + 3] == sixth [x + 1] && fourth [x + 3] == seventh [x]
		&& fourth [x + 3] == yellow && fifth [x + 2] == yellow && sixth [x + 1] == yellow && seventh [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (fourth [x] == fifth [x + 1] && fourth [x] == sixth [x + 2] && fourth [x] == seventh [x + 3]
		&& fourth [x] == red && fifth [x + 1] == red && sixth [x + 2] == red && seventh [x + 3] == red)
	    condition--;

	//downward
	else if (fourth [x + 3] == fifth [x + 2] && fourth [x + 3] == sixth [x + 1] && fourth [x + 3] == seventh [x]
		&& fourth [x + 3] == red && fifth [x + 2] == red && sixth [x + 1] == red && seventh [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin5 (int fourth[], int fifth[], int sixth[], int seventh[])
    {
	//Trending upwards
	int x = 2, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upwards
	if (fourth [x] == fifth [x + 1] && fourth [x] == sixth [x + 2] && fourth [x] == seventh [x + 3]
		&& fourth [x] == yellow && fifth [x + 1] == yellow && sixth [x + 2] == yellow && seventh [x + 3] == yellow)
	    condition++;

	//downward
	else if (fourth [x + 3] == fifth [x + 2] && fourth [x + 3] == sixth [x + 1] && fourth [x + 3] == seventh [x]
		&& fourth [x + 3] == yellow && fifth [x + 2] == yellow && sixth [x + 1] == yellow && seventh [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (fourth [x] == fifth [x + 1] && fourth [x] == sixth [x + 2] && fourth [x] == seventh [x + 3]
		&& fourth [x] == red && fifth [x + 1] == red && sixth [x + 2] == red && seventh [x + 3] == red)
	    condition--;

	//downward
	else if (fourth [x + 3] == fifth [x + 2] && fourth [x + 3] == sixth [x + 1] && fourth [x + 3] == seventh [x]
		&& fourth [x + 3] == red && fifth [x + 2] == red && sixth [x + 1] == red && seventh [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}


	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin6 (int second[], int third[], int fourth[], int fifth[])
    {
	//Trending upwards && downward
	int x = 0, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (second [x] == third [x + 1] && second [x] == fourth [x + 2] && second [x] == fifth [x + 3]
		&& second [x] == yellow && third [x + 1] == yellow && fourth [x + 2] == yellow && fifth [x + 3] == yellow)
	    condition++;

	//downward
	else if (second [x + 3] == third [x + 2] && second [x + 3] == fourth [x + 1] && second [x + 3] == fifth [x]
		&& second [x + 3] == yellow && third [x + 2] == yellow && fourth [x + 1] == yellow && fifth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (second [x] == third [x + 1] && second [x] == fourth [x + 2] && second [x] == fifth [x + 3]
		&& second [x] == red && third [x + 1] == red && fourth [x + 2] == red && fourth [x + 3] == red)
	    condition--;

	//downwards
	else if (second [x + 3] == third [x + 2] && second [x + 3] == fourth [x + 1] && second [x + 3] == fifth [x]
		&& second [x + 3] == red && third [x + 2] == red && fourth [x + 1] == red && fifth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin7 (int second[], int third[], int fourth[], int fifth[])
    {
	//Trending upwards && downward
	int x = 1, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (second [x] == third [x + 1] && second [x] == fourth [x + 2] && second [x] == fifth [x + 3]
		&& second [x] == yellow && third [x + 1] == yellow && fourth [x + 2] == yellow && fifth [x + 3] == yellow)
	    condition++;

	//downward
	else if (second [x + 3] == third [x + 2] && second [x + 3] == fourth [x + 1] && second [x + 3] == fifth [x]
		&& second [x + 3] == yellow && third [x + 2] == yellow && fourth [x + 1] == yellow && fifth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (second [x] == third [x + 1] && second [x] == fourth [x + 2] && second [x] == fifth [x + 3]
		&& second [x] == red && third [x + 1] == red && fourth [x + 2] == red && fourth [x + 3] == red)
	    condition--;

	//downwards
	else if (second [x + 3] == third [x + 2] && second [x + 3] == fourth [x + 1] && second [x + 3] == fifth [x]
		&& second [x + 3] == red && third [x + 2] == red && fourth [x + 1] == red && fifth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin8 (int second[], int third[], int fourth[], int fifth[])
    {
	//Trending upwards && downward
	int x = 2, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (second [x] == third [x + 1] && second [x] == fourth [x + 2] && second [x] == fifth [x + 3]
		&& second [x] == yellow && third [x + 1] == yellow && fourth [x + 2] == yellow && fifth [x + 3] == yellow)
	    condition++;

	//downward
	else if (second [x + 3] == third [x + 2] && second [x + 3] == fourth [x + 1] && second [x + 3] == fifth [x]
		&& second [x + 3] == yellow && third [x + 2] == yellow && fourth [x + 1] == yellow && fifth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (second [x] == third [x + 1] && second [x] == fourth [x + 2] && second [x] == fifth [x + 3]
		&& second [x] == red && third [x + 1] == red && fourth [x + 2] == red && fourth [x + 3] == red)
	    condition--;

	//downwards
	else if (second [x + 3] == third [x + 2] && second [x + 3] == fourth [x + 1] && second [x + 3] == fifth [x]
		&& second [x + 3] == red && third [x + 2] == red && fourth [x + 1] == red && fifth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin9 (int third[], int fourth[], int fifth[], int sixth[])
    {
	//Trending upwards && downward
	int x = 0, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (third [x] == fourth [x + 1] && third [x] == fifth [x + 2] && third [x] == sixth [x + 3]
		&& third [x] == yellow && fourth [x + 1] == yellow && fifth [x + 2] == yellow && sixth [x + 3] == yellow)
	    condition++;

	//downward
	else if (third [x + 3] == fourth [x + 2] && third [x + 3] == fifth [x + 1] && third [x + 3] == sixth [x]
		&& third [x + 3] == yellow && fourth [x + 2] == yellow && fifth [x + 1] == yellow && sixth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (third [x] == fourth [x + 1] && third [x] == fifth [x + 2] && third [x] == sixth [x + 3]
		&& third [x] == red && fourth [x + 1] == red && fifth [x + 2] == red && sixth [x + 3] == red)
	    condition--;

	//downwards
	else if (third [x + 3] == fourth [x + 2] && third [x + 3] == fifth [x + 1] && third [x + 3] == sixth [x]
		&& third [x + 3] == red && fourth [x + 2] == red && fifth [x + 1] == red && sixth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin10 (int third[], int fourth[], int fifth[], int sixth[])
    {
	//Trending upwards && downward
	int x = 1, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (third [x] == fourth [x + 1] && third [x] == fifth [x + 2] && third [x] == sixth [x + 3]
		&& third [x] == yellow && fourth [x + 1] == yellow && fifth [x + 2] == yellow && sixth [x + 3] == yellow)
	    condition++;

	//downward
	else if (third [x + 3] == fourth [x + 2] && third [x + 3] == fifth [x + 1] && third [x + 3] == sixth [x]
		&& third [x + 3] == yellow && fourth [x + 2] == yellow && fifth [x + 1] == yellow && sixth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (third [x] == fourth [x + 1] && third [x] == fifth [x + 2] && third [x] == sixth [x + 3]
		&& third [x] == red && fourth [x + 1] == red && fifth [x + 2] == red && sixth [x + 3] == red)
	    condition--;

	//downwards
	else if (third [x + 3] == fourth [x + 2] && third [x + 3] == fifth [x + 1] && third [x + 3] == sixth [x]
		&& third [x + 3] == red && fourth [x + 2] == red && fifth [x + 1] == red && sixth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int diagonalWin11 (int third[], int fourth[], int fifth[], int sixth[])
    {
	//Trending upwards && downward
	int x = 2, condition = 0, yellow = 1, red = 2;

	//Yellow
	//upward
	if (third [x] == fourth [x + 1] && third [x] == fifth [x + 2] && third [x] == sixth [x + 3]
		&& third [x] == yellow && fourth [x + 1] == yellow && fifth [x + 2] == yellow && sixth [x + 3] == yellow)
	    condition++;

	//downward
	else if (third [x + 3] == fourth [x + 2] && third [x + 3] == fifth [x + 1] && third [x + 3] == sixth [x]
		&& third [x + 3] == yellow && fourth [x + 2] == yellow && fifth [x + 1] == yellow && sixth [x] == yellow)
	    condition++;

	//Red
	//upwards
	if (third [x] == fourth [x + 1] && third [x] == fifth [x + 2] && third [x] == sixth [x + 3]
		&& third [x] == red && fourth [x + 1] == red && fifth [x + 2] == red && sixth [x + 3] == red)
	    condition--;

	//downwards
	else if (third [x + 3] == fourth [x + 2] && third [x + 3] == fifth [x + 1] && third [x + 3] == sixth [x]
		&& third [x + 3] == red && fourth [x + 2] == red && fifth [x + 1] == red && sixth [x] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int verticalWin (int first[], int second[], int third[], int fourth[], int fifth[], int sixth[], int seventh[])
    {
	int x = 0, condition = 0, yellow = 1, red = 2;

	//Vetical Checking for Red and Yellow

	//Yellow
	//first coloumn
	if (first [x] == yellow && first [x + 1] == yellow && first [x + 2] == yellow && first [x + 3] == yellow)
	    condition++;

	else if (first [x + 1] == yellow && first [x + 2] == yellow && first [x + 3] == yellow && first [x + 4] == yellow)
	    condition++;

	else if (first [x + 2] == yellow && first [x + 3] == yellow && first [x + 4] == yellow && first [x + 5] == yellow)
	    condition++;

	//second coloumn
	if (second [x] == yellow && second [x + 1] == yellow && second [x + 2] == yellow && second [x + 3] == yellow)
	    condition++;

	else if (second [x + 1] == yellow && second [x + 2] == yellow && second [x + 3] == yellow && second [x + 4] == yellow)
	    condition++;

	else if (second [x + 2] == yellow && second [x + 3] == yellow && second [x + 4] == yellow && second [x + 5] == yellow)
	    condition++;

	//third coloumn
	if (third [x] == yellow && third [x + 1] == yellow && third [x + 2] == yellow && third [x + 3] == yellow)
	    condition++;

	else if (third [x + 1] == yellow && third [x + 2] == yellow && third [x + 3] == yellow && third [x + 4] == yellow)
	    condition++;

	else if (third [x + 2] == yellow && third [x + 3] == yellow && third [x + 4] == yellow && third [x + 5] == yellow)
	    condition++;

	//fourth coloumn
	if (fourth [x] == yellow && fourth [x + 1] == yellow && fourth [x + 2] == yellow && fourth [x + 3] == yellow)
	    condition++;

	else if (fourth [x + 1] == yellow && fourth [x + 2] == yellow && fourth [x + 3] == yellow && fourth [x + 4] == yellow)
	    condition++;

	else if (fourth [x + 2] == yellow && fourth [x + 3] == yellow && fourth [x + 4] == yellow && fourth [x + 5] == yellow)
	    condition++;

	//fifth coloumn
	if (fifth [x] == yellow && fifth [x + 1] == yellow && fifth [x + 2] == yellow && fifth [x + 3] == yellow)
	    condition++;

	else if (fifth [x + 1] == yellow && fifth [x + 2] == yellow && fifth [x + 3] == yellow && fifth [x + 4] == yellow)
	    condition++;

	else if (fifth [x + 2] == yellow && fifth [x + 3] == yellow && fifth [x + 4] == yellow && fifth [x + 5] == yellow)
	    condition++;

	//sixth coloumn
	if (sixth [x] == yellow && sixth [x + 1] == yellow && sixth [x + 2] == yellow && sixth [x + 3] == yellow)
	    condition++;

	else if (sixth [x + 1] == yellow && sixth [x + 2] == yellow && sixth [x + 3] == yellow && sixth [x + 4] == yellow)
	    condition++;

	else if (sixth [x + 2] == yellow && sixth [x + 3] == yellow && sixth [x + 4] == yellow && sixth [x + 5] == yellow)
	    condition++;

	//seventh coloumn
	if (seventh [x] == yellow && seventh [x + 1] == yellow && seventh [x + 2] == yellow && seventh [x + 3] == yellow)
	    condition++;

	else if (seventh [x + 1] == yellow && seventh [x + 2] == yellow && seventh [x + 3] == yellow && seventh [x + 4] == yellow)
	    condition++;

	else if (seventh [x + 2] == yellow && seventh [x + 3] == yellow && seventh [x + 4] == yellow && seventh [x + 5] == yellow)
	    condition++;


	//Red
	//First Coloumn
	if (first [x] == red && first [x + 1] == red && first [x + 2] == red && first [x + 3] == red)
	    condition--;

	else if (first [x + 1] == red && first [x + 2] == red && first [x + 3] == red && first [x + 4] == red)
	    condition--;

	else if (first [x + 2] == red && first [x + 3] == red && first [x + 4] == red && first [x + 5] == red)
	    condition--;

	//second Coloumn
	if (second [x] == red && second [x + 1] == red && second [x + 2] == red && second [x + 3] == red)
	    condition--;

	else if (second [x + 1] == red && second [x + 2] == red && second [x + 3] == red && second [x + 4] == red)
	    condition--;

	else if (second [x] == red && second [x + 1] == red && second [x + 2] == red && second [x + 3] == red)
	    condition--;

	//third Coloumn
	if (third [x] == red && third [x + 1] == red && third [x + 2] == red && third [x + 3] == red)
	    condition--;

	else if (third [x + 1] == red && third [x + 2] == red && third [x + 3] == red && third [x + 4] == red)
	    condition--;

	else if (third [x + 2] == red && third [x + 3] == red && third [x + 4] == red && third [x + 5] == red)
	    condition--;

	//fourth Coloumn
	if (fourth [x] == red && fourth [x + 1] == red && fourth [x + 2] == red && fourth [x + 3] == red)
	    condition--;

	else if (fourth [x + 1] == red && fourth [x + 2] == red && fourth [x + 3] == red && fourth [x + 4] == red)
	    condition--;

	else if (fourth [x + 2] == red && fourth [x + 3] == red && fourth [x + 4] == red && fourth [x + 5] == red)
	    condition--;

	//fifth coloumn
	if (fifth [x] == red && fifth [x + 1] == red && fifth [x + 2] == red && fifth [x + 3] == red)
	    condition--;

	else if (fifth [x + 1] == red && fifth [x + 2] == red && fifth [x + 3] == red && fifth [x + 4] == red)
	    condition--;

	else if (fifth [x + 2] == red && fifth [x + 3] == red && fifth [x + 4] == red && fifth [x + 5] == red)
	    condition--;

	//sixth coloumn
	if (sixth [x] == red && sixth [x + 1] == red && sixth [x + 2] == red && sixth [x + 3] == red)
	    condition--;

	else if (sixth [x + 1] == red && sixth [x + 2] == red && sixth [x + 3] == red && sixth [x + 4] == red)
	    condition--;

	else if (sixth [x + 2] == red && sixth [x + 3] == red && sixth [x + 4] == red && sixth [x + 5] == red)
	    condition--;

	//seventh coloumn
	if (seventh [x] == red && seventh [x + 1] == red && seventh [x + 2] == red && seventh [x + 3] == red)
	    condition--;

	else if (seventh [x + 1] == red && seventh [x + 2] == red && seventh [x + 3] == red && seventh [x + 4] == red)
	    condition--;

	else if (seventh [x + 2] == red && seventh [x + 3] == red && seventh [x + 4] == red && seventh [x + 5] == red)
	    condition--;

	//print statment
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;

    }


    public static int win (int first[], int second[], int third[], int fourth[], int fifth[], int sixth[], int seventh[])
    {
	int x = 0, yellow = 1, red = 2, win = 0, condition = 0;
	//Horizontal Checking for Yellow and Red

	//Yellow

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == yellow && second [x] == yellow && third [x] == yellow && fourth [x] == yellow)
	    condition++;

	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == yellow && third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow)
	    condition++;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow)
	    condition++;

	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow && seventh [x] == yellow)
	    condition++;

	//Red

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == red && second [x] == red && third [x] == red && fourth [x] == red)
	    condition--;

	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == red && third [x] == red && fourth [x] == red && fifth [x] == red)
	    condition--;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == red && fourth [x] == red && fifth [x] == red && sixth [x] == red)
	    condition--;

	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == red && fifth [x] == red && sixth [x] == red && seventh [x] == red)
	    condition--;

	//print statement
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;

    }


    public static int win1 (int first[], int second[], int third[], int fourth[], int fifth[], int sixth[], int seventh[])
    {
	int x = 1, yellow = 1, red = 2, condition = 0;

	//Horizontal Checking for Yellow and Red

	//Yellow

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == yellow && second [x] == yellow && third [x] == yellow && fourth [x] == yellow)
	    condition++;

	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == yellow && third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow)
	    condition++;


	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow)
	    condition++;

	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow && seventh [x] == yellow)
	    condition++;


	//Red

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == red && second [x] == red && third [x] == red && fourth [x] == red)
	    condition--;


	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == red && third [x] == red && fourth [x] == red && fifth [x] == red)
	    condition--;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == red && fourth [x] == red && fifth [x] == red && sixth [x] == red)
	    condition--;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == red && fifth [x] == red && sixth [x] == red && seventh [x] == red)
	    condition--;

	//print statement
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;

    }


    public static int win2 (int first[], int second[], int third[], int fourth[], int fifth[], int sixth[], int seventh[])
    {
	int x = 2, yellow = 1, red = 2, condition = 0;
	//Horizontal Checking for Yellow and Red

	//Yellow

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == yellow && second [x] == yellow && third [x] == yellow && fourth [x] == yellow)
	    condition++;


	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == yellow && third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow)
	    condition++;


	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow)
	    condition++;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow && seventh [x] == yellow)
	    condition++;


	//Red

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == red && second [x] == red && third [x] == red && fourth [x] == red)
	    condition--;


	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == red && third [x] == red && fourth [x] == red && fifth [x] == red)
	    condition--;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == red && fourth [x] == red && fifth [x] == red && sixth [x] == red)
	    condition--;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == red && fifth [x] == red && sixth [x] == red && seventh [x] == red)
	    condition--;


	//print statement
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;
    }


    public static int win3 (int first[], int second[], int third[], int fourth[], int fifth[], int sixth[], int seventh[])
    {
	int x = 3, yellow = 1, red = 2, win = 0, condition = 0;
	//Horizontal Checking for Yellow and Red

	//Yellow

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == yellow && second [x] == yellow && third [x] == yellow && fourth [x] == yellow)
	    condition++;


	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == yellow && third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow)
	    condition++;


	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow)
	    condition++;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow && seventh [x] == yellow)
	    condition++;


	//Red

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == red && second [x] == red && third [x] == red && fourth [x] == red)
	    condition--;


	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == red && third [x] == red && fourth [x] == red && fifth [x] == red)
	    condition--;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == red && fourth [x] == red && fifth [x] == red && sixth [x] == red)
	    condition--;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == red && fifth [x] == red && sixth [x] == red && seventh [x] == red)
	    condition--;


	//print statement
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;

    }


    public static int win4 (int first[], int second[], int third[], int fourth[], int fifth[], int sixth[], int seventh[])
    {
	int x = 4, yellow = 1, red = 2, win = 0, condition = 0;
	//Horizontal Checking for Yellow and Red

	//Yellow

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == yellow && second [x] == yellow && third [x] == yellow && fourth [x] == yellow)
	    condition++;


	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == yellow && third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow)
	    condition++;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow)
	    condition++;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow && seventh [x] == yellow)
	    condition++;


	//Red

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == red && second [x] == red && third [x] == red && fourth [x] == red)
	    condition--;


	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == red && third [x] == red && fourth [x] == red && fifth [x] == red)
	    condition--;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == red && fourth [x] == red && fifth [x] == red && sixth [x] == red)
	    condition--;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == red && fifth [x] == red && sixth [x] == red && seventh [x] == red)
	    condition--;


	//print statement
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;

    }


    public static int win5 (int first[], int second[], int third[], int fourth[], int fifth[], int sixth[], int seventh[])
    {
	int x = 5, yellow = 1, red = 2, win = 0, condition = 0;
	//Horizontal Checking for Yellow and Red

	//Yellow

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == yellow && second [x] == yellow && third [x] == yellow && fourth [x] == yellow)
	    condition++;

	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == yellow && third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow)
	    condition++;


	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == yellow && fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow)
	    condition++;

	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == yellow && fifth [x] == yellow && sixth [x] == yellow && seventh [x] == yellow)
	    condition++;


	//Red

	if (first [x] == second [x] && first [x] == third [x] && first [x] == fourth [x]
		&& first [x] == red && second [x] == red && third [x] == red && fourth [x] == red)
	    condition--;

	else if (second [x] == third [x] && second [x] == fourth [x] && second [x] == fifth [x]
		&& second [x] == red && third [x] == red && fourth [x] == red && fifth [x] == red)
	    condition--;

	else if (third [x] == fourth [x] && third [x] == fifth [x] && third [x] == sixth [x]
		&& third [x] == red && fourth [x] == red && fifth [x] == red && sixth [x] == red)
	    condition--;


	else if (fourth [x] == fifth [x] && fourth [x] == sixth [x] && fourth [x] == seventh [x]
		&& fourth [x] == red && fifth [x] == red && sixth [x] == red && seventh [x] == red)
	    condition--;


	//print statement
	if (condition == 1)
	{
	    winningStatement (yellow);
	}
	else if (condition == -1)
	{
	    winningStatement (red);
	}
	return condition;

    }


    public static void game (int right, int stop, int t)
    {



	int x = 1, y = 30;
	while (y != stop)

	    {
		y = y + 80;

		if (t % 2 == 0)
		{
		    c.setColor (new Color (255, 255, 255));
		    c.drawLine (550, 550, 630, 550);
		    c.drawLine (550, 520, 630, 520);

		    c.setColor (new Color (255, 255, 0));
		    c.drawLine (25, 550, 90, 550);
		    c.drawLine (25, 520, 90, 520);
		}
		else
		{

		    c.setColor (new Color (255, 255, 255));
		    c.drawLine (25, 550, 90, 550);
		    c.drawLine (25, 520, 90, 520);
		    c.setColor (new Color (220, 20, 60));
		    c.drawLine (550, 550, 630, 550);
		    c.drawLine (550, 520, 630, 520);
		}
		c.fillOval (right, y, 50, 50);


		try
		{
		    Thread.sleep (100);
		}
		catch (InterruptedException ex)
		{
		    Thread.currentThread ().interrupt ();
		}


		if (t % 2 == 0)
		{
		    c.setColor (new Color (255, 255, 0));
		}
		else
		{
		    c.setColor (new Color (220, 20, 60));
		}
		c.setColor (new Color (255, 255, 255));
		c.fillOval (right, y, 50, 50);
	    }


	if (t % 2 == 0)
	{
	    c.setColor (new Color (255, 255, 0));
	}


	else
	{
	    c.setColor (new Color (220, 20, 60));
	}


	c.fillOval (right, stop, 50, 50);

    }


    public static void board ()
    {

	Font f = new Font ("Arial", Font.BOLD, 15);
	int x, y;
	c.setColor (new Color (0, 0, 255));
	c.fillRect (25, 25, 600, 470);

	c.setColor (new Color (255, 255, 255));
	for (x = 50 ; x <= 530 ; x = x + 80)
	{

	    y = 30;
	    for (int b = 0 ; b < 6 ; b++)
	    {
		c.fillOval (x, y, 50, 50);
		y = y + 80;
	    }
	}
	c.setColor (new Color (0, 0, 0));
	c.setFont (f);
	c.drawString ("1", 70, 20);
	c.drawString ("2", 150, 20);
	c.drawString ("3", 230, 20);
	c.drawString ("4", 310, 20);
	c.drawString ("5", 390, 20);
	c.drawString ("6", 470, 20);
	c.drawString ("7", 550, 20);
    }


    public static void winningStatement (int color)
    {
	char choice;
	Font f = new Font ("Aharoni", Font.PLAIN, 65);
	Font a = new Font ("Aharoni", Font.PLAIN, 30);
	Font b = new Font ("Aharoni", Font.PLAIN, 50);
	Font t = new Font ("Aharoni", Font.PLAIN, 70);

	try
	{
	    Thread.sleep (500);
	}


	catch (InterruptedException ex)
	{
	    Thread.currentThread ().interrupt ();
	}


	c.clear ();

	if (color == 1)
	{
	    c.setFont (t);
	    c.setColor (new Color (255, 0, 0));
	    c.drawString (player1 + "!", 309, 250);

	    c.setFont (f);
	    c.setColor (new Color (0, 0, 128));
	    c.drawString ("YOU WIN!", 185, 330);
	    c.drawString ("Congratulations!", 100, 400);
	}


	else if (color == 2)
	{
	    c.setFont (t);
	    c.setColor (new Color (255, 0, 0));
	    c.drawString (player2 + "!", 309, 250);

	    c.setFont (f);
	    c.setColor (new Color (0, 0, 128));
	    c.drawString ("YOU WIN!", 185, 330);
	    c.drawString ("Congratulations!", 100, 400);
	}
	else
	{
	    c.setFont (f);
	    c.setColor (new Color (0, 0, 128));
	    c.drawString ("It's a Draw!", 170, 290);
	}

	c.getChar ();
	c.clear ();

	c.setFont (a);
	c.drawString ("Do you want to play again?", 130, 240);
	c.setFont (b);
	c.setColor (new Color (0, 100, 0));
	c.drawString ("Y", 260, 300);
	c.setColor (new Color (0, 0, 128));
	c.drawString (" / ", 300, 300);
	c.setColor (new Color (255, 0, 0));
	c.drawString ("N", 340, 300);

	choice = c.getChar ();

	if (choice == 'y' || choice == 'Y')
	    gameStart ();
	else
	    c.close ();

    }


    public static void gameStart ()
    {
	Font f = new Font ("Aharoni", Font.PLAIN, 30);
	int a = 1;

	c.clear ();
	c.setFont (f);
	c.setColor (new Color (0, 0, 128));
	c.setCursor (13, 50);
	c.drawString ("Player 1 Initial: ", 137, 260);
	player1 = c.readLine ();
	c.drawString (player1, 200, 260);


	c.clear ();
	c.setCursor (15, 50);
	c.drawString ("Player 2 Initial: ", 147, 296);
	player2 = c.readLine ();

	for (int i = 0 ; i < player2.length () ; i++)
	{
	    if (player2.charAt (i) != ' ') //check for spaces
	    {
		nameLength++; //increment the name length counter
	    }
	}
	gameBoard ();
    }


    // How to Play

    public static void rules ()
    {
	Font f = new Font ("Aharoni", Font.PLAIN, 24);
	Font b = new Font ("Aharoni", Font.PLAIN, 30);
	Font l = new Font ("Aharoni", Font.PLAIN, 20);
	Font u = new Font ("Aharoni", Font.PLAIN, 15);
	int a = 10, d = 390, e = 100, g = 490;

	c.clear ();

	c.setFont (f);

	c.setColor (new Color (255, 255, 0));
	c.fillOval (150, 190, 60, 60); // Yellow Circle

	c.setColor (new Color (0, 0, 0));
	c.drawString ("Counter for player 1", 260, 229);

	c.setColor (new Color (255, 0, 0));
	c.fillOval (150, 290, 60, 60); // Red Circle

	c.setColor (new Color (0, 0, 0));
	c.drawString ("Counter for player 2", 260, 330);

	c.drawString ("<Press any key to continue>", 170, 460);

	c.setFont (b);
	c.drawString ("Player 1 goes", 200, 120);
	c.setColor (new Color (255, 0, 0));
	c.drawString ("FIRST!", 400, 120);

	c.getChar ();
	c.clear ();

	c.setColor (new Color (0, 0, 0));
	c.setFont (f);
	c.drawString ("Get your four counters in a row: ", 150, 130);

	c.drawString ("Horizontally", 250, 200);
	c.drawString ("Vertically", 265, 290);
	c.drawString ("Diagonally", 255, 390);

	//Horizontal Combination
	for (int x = 70 ; x <= 160 ; x = x + 30)
	{
	    c.setColor (new Color (255, 255, 0));
	    c.fillOval (x, 180, 30, 30); // Yellow Circle
	}
	for (int x = 460 ; x <= 550 ; x = x + 30)
	{
	    c.setColor (new Color (255, 0, 0));
	    c.fillOval (x, 180, 30, 30); // Red Circle
	}

	// Vertical Combination
	for (int y = 220 ; y <= 310 ; y = y + 30)
	{
	    c.setColor (new Color (255, 255, 0));
	    c.fillOval (115, y, 30, 30); // Yellow Circle
	}
	for (int y = 220 ; y <= 310 ; y = y + 30)
	{
	    c.setColor (new Color (255, 0, 0));
	    c.fillOval (508, y, 30, 30); // Red Circle
	}

	//Diagonal Combination

	for (int y = 330 ; y <= 390 ; y = y + 20)
	{
	    c.setColor (new Color (255, 255, 0));
	    c.fillOval (a, y, 30, 30); // Yellow Circle
	    a = a + 30;
	}

	for (int y = 330 ; y <= 390 ; y = y + 20)
	{
	    c.setColor (new Color (255, 0, 0));
	    c.fillOval (d, y, 30, 30); // Red Circle
	    d = d + 30;
	}

	for (int y = 450 ; y >= 390 ; y = y - 20)
	{
	    c.setColor (new Color (255, 255, 0));
	    c.fillOval (e, y, 30, 30); // Yellow Circle
	    e = e + 35;
	}

	for (int y = 430 ; y >= 360 ; y = y - 20)
	{
	    c.setColor (new Color (255, 0, 0));
	    c.fillOval (g, y, 30, 30); // Red Circle
	    g = g + 35;
	}

	c.setColor (new Color (0, 0, 0));
	c.drawString ("<Press any key to continue>", 170, 500);

	c.getChar ();
	c.clear ();

	c.setColor (new Color (255, 0, 0));
	c.drawString ("1", 70, 530);
	c.drawString ("2", 150, 530);
	c.drawString ("3", 230, 530);
	c.drawString ("4", 310, 530);
	c.drawString ("5", 390, 530);
	c.drawString ("6", 470, 530);
	c.drawString ("7", 550, 530);

	c.setFont (l);
	c.setColor (new Color (0, 0, 0));
	c.drawString ("Enter a number from 1 to 7 to drop a counter in that coloumn", 40, 565);
	board ();

	c.setFont (u);
	c.setColor (new Color (0, 0, 0));
	c.drawString ("<Press any key to continue>", 210, 595);

	c.getChar ();
	c.clear ();
    }


    // MENU

    public static void main (String[] args)
    {
	c = new Console (30, 80);

	char choice;
	int x = 0;
	Font b = new Font ("Consolas", Font.PLAIN, 20);

	Font f = new Font ("Britannic Bold", Font.PLAIN, 65);
	Font a = new Font ("Arial Rounded MT Bold", Font.PLAIN, 80);

	c.setFont (f);
	c.setColor (new Color (0, 0, 128));
	c.drawString ("CONNECT ", 150, 250);
	c.setFont (a);
	c.setColor (new Color (220, 20, 60));
	c.drawString ("4!", 430, 250);

	//delay of 500 millisecond until next display
	try
	{
	    Thread.sleep (500);
	}


	catch (InterruptedException ex)
	{
	    Thread.currentThread ().interrupt ();
	}


	do
	{
	    c.setFont (f);

	    c.setColor (new Color (0, 0, 128));
	    c.drawString ("CONNECT ", 150, 250);

	    c.setFont (a);

	    c.setColor (new Color (220, 20, 60));
	    c.drawString ("4!", 430, 250);

	    c.setFont (b);

	    c.setColor (new Color (0, 0, 128));
	    c.drawString (" Play (2 Player)", 245, 310);
	    c.drawString (" How to play", 245, 340);
	    c.drawString (" Quit", 245, 370);

	    c.setColor (new Color (220, 20, 60));
	    c.drawString ("1. ", 230, 310);
	    c.drawString ("2. ", 230, 340);
	    c.drawString ("0. ", 230, 370);

	    choice = c.getChar ();

	    if (choice == '1')
		gameStart ();

	    else if (choice == '2')
		rules ();
	}


	while (choice != '0');

	c.close ();

    } // main method
} // ConnectFour class


