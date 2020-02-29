package com.henez.distant.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.henez.distant.datastructures.Rect;
import com.henez.distant.global.Global;

public class Renderer {

    public Batcher batcher;
    public Shaper shaper;
    public OrthographicCamera camera;

    public Renderer() {
        batcher = new Batcher();
        shaper = new Shaper();
        ShaderProgram.pedantic = false;
        resetCamera();
    }

    //public void setShader(ShaderClass shaderClass) {
    //    batch.setShader(shaderClass.shader);
    //}

    /*public void setShaderSpell(Colors colorPrimary, Colors colorSecondary) {
    
        ShaderProgram shader = ShaderClass.SPELL.shader;
        shader.begin();
        shader.setUniform3fv("colorPrimary", colorPrimary.getAsFloats3(),0,3);
        shader.setUniform3fv("colorSecondary", colorSecondary.getAsFloats3(),0,3);
        shader.setUniform3fv("colorBlack", Colors.ui_blue_darkest.getAsFloats3(),0,3);
        shader.end();
        batch.setShader(shader);
    }*/

    public void resetShader() {
        batcher.setShader(null);
    }

    public void resetCamera() {
        camera = new OrthographicCamera(Global.cameraPixelW, Global.cameraPixelH);
        camera.setToOrtho(true, Global.cameraPixelW, Global.cameraPixelH);
        batcher.setProjectionMatrix(camera.combined);
        shaper.setProjectionMatrix(camera.combined);
    }

    private void update() {
        camera.position.x = (int) camera.position.x;
        camera.position.y = (int) camera.position.y;
        camera.update();
        batcher.setProjectionMatrix(camera.combined);
        shaper.setProjectionMatrix(camera.combined);
    }

    public void positionCamera(float x, float y) {
        //camera.position.set(x,y,1);
        camera.position.x = x + (Global.cameraPixelWW);
        camera.position.y = y + (Global.cameraPixelHH);
        update();
    }

    public void positionCameraOn(Rect pos) {
        positionCamera(pos.getIntX() + Global.tilePixel2 - Global.cameraPixelWW, pos.getIntY() + Global.tilePixel2 - Global.cameraPixelHH);
    }

    public void moveCamera(float x, float y) {
        camera.position.x += x;
        camera.position.y += y;
        update();
    }

    public void moveCameraInverse(float x, float y) {
        camera.position.x -= x;
        camera.position.y -= y;
        update();
    }

    public void dispose() {
        batcher.dispose();
        shaper.dispose();
    }

    public int getX() {
        return (int) camera.position.x - Global.cameraPixelWW;
    }

    public int getY() {
        return (int) camera.position.y - Global.cameraPixelHH;
    }

    public int getW() {
        return Global.cameraPixelW;
    }

    public int getH() {
        return Global.cameraPixelH;
    }

    public int getXX() {
        return (int) camera.position.x + Global.cameraPixelWW;
    }

    public int getYY() {
        return (int) camera.position.y + Global.cameraPixelHH;
    }

    public float getXF() {
        return camera.position.x - Global.cameraPixelWW;
    }

    public float getYF() {
        return camera.position.y - Global.cameraPixelHH;
    }
}
