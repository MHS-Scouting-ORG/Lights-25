package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase {
  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;
  private int rainbowFirstPixelHue = 0;
  private boolean rainbowOn = false;

  public Lights() {
    m_led = new AddressableLED(9);
    m_ledBuffer = new AddressableLEDBuffer(100);
    m_led.setLength(m_ledBuffer.getLength());
    m_led.setData(m_ledBuffer);
    m_led.start();
  }
  public void toggleRainbow(){
    if (!rainbowOn) {
      rainbowOn = true;
    }
    else{
      rainbowOn = false;
    }
    
  }
  public void rainbow() {
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      int hue = (rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;
      m_ledBuffer.setHSV(i, hue, 255, 128);
    }
    m_led.setData(m_ledBuffer);
    rainbowFirstPixelHue += 3;
    rainbowFirstPixelHue %= 180;
    

  }

  public void off() {
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 0, 0, 0);
    }
    m_led.setData(m_ledBuffer);
  }

  public void sunflower() {
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 55, 55, 0);
    }
    m_led.setData(m_ledBuffer);
  }
  
  public void lavendar() {
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 55, 0, 55);
    }
    m_led.setData(m_ledBuffer);
  }
  
  public void poppy() {
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
      m_ledBuffer.setRGB(i, 255, 0, 0);
    }
    m_led.setData(m_ledBuffer);
  }

  public void potOfGold() {
    for (int i = 0; i < m_ledBuffer.getLength(); i += 6) {
      m_ledBuffer.setRGB(i, 255, 0, 0);
    }
    for (int i = 1; i < m_ledBuffer.getLength(); i += 6) {
      m_ledBuffer.setRGB(i, 255, 165, 0);
    }
    for (int i = 2; i < m_ledBuffer.getLength(); i += 6) {
      m_ledBuffer.setRGB(i, 255, 255, 0);
    }
    for (int i = 3; i < m_ledBuffer.getLength(); i += 6) {
      m_ledBuffer.setRGB(i, 0, 255, 0);
    }
    for (int i = 4; i < m_ledBuffer.getLength(); i += 6) {
      m_ledBuffer.setRGB(i, 255, 0, 255);
    }
    for (int i = 5; i < m_ledBuffer.getLength(); i += 6) {
      m_ledBuffer.setRGB(i, 255, 0, 255);
    }
    m_led.setData(m_ledBuffer);
  }
  
  @Override
  public void periodic() {
    if (rainbowOn) {
      rainbow();
    }
  }
}
