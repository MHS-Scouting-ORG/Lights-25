package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase {
    private AddressableLED m_led;
    private AddressableLEDBuffer m_ledBuffer;
    private static final int kPort = 9;
    private static final int kLength = 100;

    private boolean isIdleOn = false;
    private int idleOffset = 0; // Keeps track of animation step

    public Lights() {
        m_led = new AddressableLED(kPort);
        m_ledBuffer = new AddressableLEDBuffer(kLength);
        m_led.setLength(m_ledBuffer.getLength());
        m_led.setData(m_ledBuffer);
        m_led.start();
    }

    public void algeaIntake() {
        setSolidColor(51, 163, 145);
        Timer.delay(0.08);
        setSolidColor(0, 0, 0);
        Timer.delay(0.08);
        setSolidColor(51, 163, 145);
        Timer.delay(0.08);
        setSolidColor(0, 0, 0);
        
    }

    public void coralIntake() {
        setSolidColor(163, 161, 137);
        Timer.delay(0.08);
        setSolidColor(0, 0, 0);
        Timer.delay(0.08);
        setSolidColor(163, 161, 137);
        Timer.delay(0.08);
        setSolidColor(0, 0, 0);
    }

    public void reefTracking() {
        setSolidColor(153, 1, 255);
        
    }

    public void processorTracking() {
        setSolidColor(25, 26, 137);
    }

    public void scored() {
        setSolidColor(255, 253, 85);
        Timer.delay(0.08);
        setSolidColor(0, 0, 0);
        Timer.delay(0.08);
        setSolidColor(255, 253, 85);
        setSolidColor(0, 0, 0);
        Timer.delay(0.08);
        setSolidColor(255, 253, 85);
        Timer.delay(0.08);
        setSolidColor(0, 0, 0);


    }

    public void off() {
        setSolidColor(0, 0, 0);
    }

    private void setSolidColor(int r, int g, int b) {
        for (int i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, r, g, b);
        }
        m_led.setData(m_ledBuffer);
    }

    /** Creates a scrolling blue/yellow/white animation */
    private void updateIdleAnimation() {
        idleOffset = (idleOffset + 1) % 4; // Cycle through offsets

        for (int i = 0; i < m_ledBuffer.getLength(); i++) {
            int pos = (i + idleOffset) % 4;

            if (pos == 0) {
                m_ledBuffer.setRGB(i, 0, 2, 61);
            } else if (pos == 1) {
                m_ledBuffer.setRGB(i, 255, 255, 255);
            } else if (pos == 2) {
                m_ledBuffer.setRGB(i, 255, 253, 85);
            } else {
                m_ledBuffer.setRGB(i, 0, 0, 0);
            }
        }
        m_led.setData(m_ledBuffer);
    }

    @Override
    public void periodic() {
        if (isIdleOn) {
            updateIdleAnimation();
            Timer.delay(0.1); // jovi come here this is ur problem for loop overrun!!
        }
    }

    public void toggleIdleStatus() {
        isIdleOn = !isIdleOn;
    }
}
