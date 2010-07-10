#include "testApp.h"

//--------------------------------------------------------------
void testApp::setup(){
//	Example of event listening
//	ofAddListener(gestures.getEventType(), this, &testApp::onGesture);
}

//--------------------------------------------------------------
void testApp::update(){
}

//--------------------------------------------------------------
void testApp::draw(){
	ofBackground(255,255,255);

	// Path drawing
	Path2D& path = gestures.getPath();
	if (path.size()>1)
	{
		ofSetColor(209,0,0);
		Point2D A,B;
		for (int i=0;i<path.size()-1;i++)
		{
			A = path[i];
			B = path[i+1];
			ofLine(A.x,A.y,B.x,B.y);
		}
	}
	
}

//--------------------------------------------------------------
void testApp::keyPressed(int key){

}

//--------------------------------------------------------------
void testApp::keyReleased(int key){

}

//--------------------------------------------------------------
void testApp::mouseMoved(int x, int y ){
}

//--------------------------------------------------------------
void testApp::mouseDragged(int x, int y, int button){
	gestures.addPoint(x,y);
}

//--------------------------------------------------------------
void testApp::mousePressed(int x, int y, int button){
}

//--------------------------------------------------------------
void testApp::mouseReleased(int x, int y, int button){
	ofxGestureResult result = gestures.end();
	printf("--> %s (score : %.3f) \n", result.name.c_str(), (float)result.score);
}

//--------------------------------------------------------------
void testApp::windowResized(int w, int h){
}


//--------------------------------------------------------------
void testApp::onGesture(ofxGestureResult& result)
{

}