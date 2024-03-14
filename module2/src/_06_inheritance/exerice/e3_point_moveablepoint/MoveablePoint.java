package _06_inheritance.exerice.e3_point_moveablepoint;

public class MoveablePoint extends Point2D {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint(){ }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed= ySpeed;
    }

    public float[] getSpeed(){
        return new float[]{xSpeed,ySpeed};
    }

    public MoveablePoint move(){
        setX(getX()+ xSpeed);
        setY(getY()+ ySpeed);
        return this;
    }

    @Override
    public String toString() {
        String res= String.format("(x= %f, y= %f), speed= (xSpeed= %f, xSpeed= %f)", getX(), getY(), xSpeed, ySpeed);
        return res;
    }
}
