#ifndef OFX_ONEDOLLARRECOGNIZER_H
#define OFX_ONEDOLLARRECOGNIZER_H

// Here ! --> http://depts.washington.edu/aimgroup/proj/dollar/

#include "ofMain.h"
#include "GeometricRecognizer.h"
#define ofxGestureResult RecognitionResult
using namespace DollarRecognizer;

class ofxOneDollarRecognizer
{
	public:
		ofxOneDollarRecognizer			()
										{
											gesture.loadTemplates();
										};
		~ofxOneDollarRecognizer			(){};

		// addPoint
		void				addPoint	(float x, float y)
										{
											path.push_back( Point2D((double)x, (double)y) );
										}
										
		// end
		ofxGestureResult	end			()
										{
											ofxGestureResult result = gesture.recognize(path);
											centroid = gesture.centroid(path);

											ofNotifyEvent(gestureDetected,result);		
											path.clear();
										
											return result;
										}
		// 	loadTemplates							
		void				loadTemplates(string filename)
										{
											// TODO : later :)
										}
										
		Path2D&							getPath				(){return path;}
		Point2D&						getPathCentroid		(){return centroid;} // only valid @ the end of gesture

		ofEvent<RecognitionResult>		gestureDetected;
		
	protected:
		GeometricRecognizer			gesture;
		Path2D						path;
		Point2D						centroid;
};

#endif


