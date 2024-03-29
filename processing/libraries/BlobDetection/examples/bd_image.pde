import blobDetection.*;

BlobDetection theBlobDetection;
PImage img;

// ==================================================
// setup()
// ==================================================
void setup()
{
	img = loadImage("Shadow.jpg");
	theBlobDetection = new BlobDetection(img.width, img.height);
	theBlobDetection.setPosDiscrimination(false);
	theBlobDetection.setThreshold(0.38f);
	theBlobDetection.computeBlobs(img.pixels);

	// Size of applet
	size(img.width*3, img.height*3);
}

// ==================================================
// draw()
// ==================================================
void draw()
{
	image(img,0,0,width,height);
	drawBlobsAndEdges(false,true);
}

// ==================================================
// drawBlobsAndEdges()
// ==================================================
void drawBlobsAndEdges(boolean drawBlobs, boolean drawEdges)
{
	noFill();
	Blob b;
	EdgeVertex eA,eB;
	for (int n=0 ; n<theBlobDetection.getBlobNb() ; n++)
	{
		b=theBlobDetection.getBlob(n);
		if (b!=null)
		{
			// Edges
			if (drawEdges)
			{
				strokeWeight(3);
				stroke(0,255,0);
				for (int m=0;m<b.getEdgeNb();m++)
				{
					eA = b.getEdgeVertexA(m);
					eB = b.getEdgeVertexB(m);
					if (eA !=null && eB !=null)
						line(
							eA.x*width, eA.y*height, 
							eB.x*width, eB.y*height
							);
				}
			}

			// Blobs
			if (drawBlobs)
			{
				strokeWeight(1);
				stroke(255,0,0);
				rect(
					b.xMin*width,b.yMin*height,
					b.w*width,b.h*height
					);
			}

		}

      }
}
