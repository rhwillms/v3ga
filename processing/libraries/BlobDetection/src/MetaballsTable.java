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
//class MetaballsTable
//==================================================
public class MetaballsTable
{
// Edge Cut Array
// ------------------------------
public static int edgeCut[][] =   
{
	{-1, -1, -1, -1, -1}, //0
	{ 0,  3, -1, -1, -1}, //3
	{ 0,  1, -1, -1, -1}, //1
	{ 3,  1, -1, -1, -1}, //2
	{ 1,  2, -1, -1, -1}, //0
	{ 1,  2,  0,  3, -1}, //3
	{ 0,  2, -1, -1, -1}, //1
	{ 3,  2, -1, -1, -1}, //2
	{ 3,  2, -1, -1, -1}, //2
	{ 0,  2, -1, -1, -1}, //1
	{ 1,  2,  0,  3, -1}, //3
	{ 1,  2, -1, -1, -1}, //0
	{ 3,  1, -1, -1, -1}, //2
	{ 0,  1, -1, -1, -1}, //1
	{ 0,  3, -1, -1, -1}, //3
	{-1, -1, -1, -1, -1}  //0
};

// EdgeOffsetInfo Array
// ------------------------------
public static int edgeOffsetInfo[][] =  
{
	{0,0,0},
	{1,0,1},
	{0,1,0},
	{0,0,1}

};

// EdgeToCompute Array
// ------------------------------
public static int edgeToCompute[] = {0,3,1,2,0,3,1,2,2,1,3,0,2,1,3,0};

// neightborVoxel Array
// ------------------------------
// bit 0 : X+1
// bit 1 : X-1
// bit 2 : Y+1
// bit 3 : Y-1
public static byte neightborVoxel[] = {0,10,9,3,5,15,12,6,6,12,12,5,3,9,10,0};  
public static void computeNeighborTable()
{
 int iEdge;
 int n;
 for (int i=0 ; i<16 ; i++)
 {
     neightborVoxel[i] = 0;

	n = 0;
	while ( (iEdge = MetaballsTable.edgeCut[i][n++]) != -1)
	{
         switch (iEdge)
         {
           case 0:
             neightborVoxel[i] |= (1<<3);     
           break;
           case 1:
             neightborVoxel[i] |= (1<<0);     
           break;
           case 2:
             neightborVoxel[i] |= (1<<2);     
           break;
           case 3:
             neightborVoxel[i] |= (1<<1);     
           break;
         }
     }    
         
 } // end for i

 
}

}
