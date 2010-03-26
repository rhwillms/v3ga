/*
	BlobDetection Library for Java & Processing

	Copyright (c) 2005-2010 by Julien Gachadoat (http://www.v3ga.net)


    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/


package blobDetection;

//==================================================
//class Blob
//==================================================
public class Blob
{
	public BlobDetection parent;
	
	public int   	id;
	public float 	x,y;   // position of its center
	public float 	w,h;   // width & height
	public float 	xMin, xMax, yMin, yMax;

	public int[] 	line;  
	public int 		nbLine;
	
	public static int MAX_NBLINE = 4000;    

public Blob(BlobDetection parent)
{
	this.parent = parent;
	line = new int[MAX_NBLINE];  // stack of index
	nbLine = 0;
}

public EdgeVertex getEdgeVertexA(int iEdge)
{
	if (iEdge*2<parent.nbLineToDraw*2)
		return parent.getEdgeVertex(line[iEdge*2]);
	else
		return null;
}

public EdgeVertex getEdgeVertexB(int iEdge)
{
	if ((iEdge*2+1)<parent.nbLineToDraw*2)
		return parent.getEdgeVertex(line[iEdge*2+1]);
	else
		return null;
}


public int getEdgeNb()
{
	return nbLine;
}

public void update()
{
	w = (xMax-xMin);
	h = (yMax-yMin);
	x = 0.5f*(xMax+xMin);
	y = 0.5f*(yMax+yMin);

	nbLine /= 2;  
}


};