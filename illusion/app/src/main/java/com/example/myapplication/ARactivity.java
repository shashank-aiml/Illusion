package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ARactivity extends AppCompatActivity {
//    private ArFragment arFragment;
//    private ModelRenderable modelRenderable;
    //3d model credit
    private String Model_URL = "https://modelviewer.dev/shared-assets/models/Astronaut.glb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aractivity2);
//        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
//        setUpModel();
//        setUpPlane();
    }
//    private void setUpModel() {
//        ModelRenderable.builder()
//                .setSource(this,
//                        RenderableSource.builder().setSource(
//                                        this,
//                                        Uri.parse(Model_URL),
//                                        RenderableSource.SourceType.GLB)
//                                .setScale(0.75f)
//                                .setRecenterMode(RenderableSource.RecenterMode.ROOT)
//                                .build())
//
//                .setRegistryId(Model_URL)
//
//
//
//                .build()
//                .thenAccept(renderable -> modelRenderable = renderable)
//                .exceptionally(throwable -> {
//                    Log.i("Model","cant load");
//                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
//                    return null;
//                });
//    }
//
//    private void setUpPlane(){
//        arFragment.setOnTapArPlaneListener(((hitResult, plane, motionEvent) -> {
//            Anchor anchor = hitResult.createAnchor();
//            AnchorNode anchorNode = new AnchorNode(anchor);
//            anchorNode.setParent(arFragment.getArSceneView().getScene());
//            createModel(anchorNode);
//        }));
//    }
//
//    private void createModel(AnchorNode anchorNode){
//        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
//        node.setParent(anchorNode);
//        node.setRenderable(modelRenderable);
//        node.select();
//    }
}