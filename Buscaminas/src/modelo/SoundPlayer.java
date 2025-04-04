package modelo;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    private boolean isPlaying = true;

    /**
     * Reproduce un sonido en bucle.
     * @param filename El nombre del archivo de sonido a reproducir.
     * @param volume El volumen de reproducción (en rango de -80.0f a 6.0f).
     */
    public void playLoop(String filename, float volume) {
        new Thread(() -> {
            while (isPlaying) {
                playSound(filename, volume);
            }
        }).start();
    }

    /**
     * Reproduce un sonido solo una vez.
     * @param filename El nombre del archivo de sonido a reproducir.
     * @param volume El volumen de reproducción (en rango de -80.0f a 6.0f).
     */
    public static void playOnce(String filename, float volume) {
        new Thread(() -> playSound(filename, volume)).start();
    }

    /**
     * Reproduce el sonido desde un archivo especificado.
     * @param filename El nombre del archivo de sonido a reproducir.
     * @param volume El volumen de reproducción.
     */
    private static void playSound(String filename, float volume) {
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filename))) {
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

            try (SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(info)) {
                sourceLine.open(audioFormat);
                adjustVolume(sourceLine, volume);
                sourceLine.start();

                byte[] buffer = new byte[128000];
                int bytesRead;

                while ((bytesRead = audioStream.read(buffer, 0, buffer.length)) != -1) {
                    sourceLine.write(buffer, 0, bytesRead);
                }

                sourceLine.drain();
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajusta el volumen de la reproducción.
     * @param sourceLine La línea de audio sobre la cual se ajustará el volumen.
     * @param volume El valor del volumen a aplicar (rango de -80.0f a 6.0f).
     */
    private static void adjustVolume(SourceDataLine sourceLine, float volume) {
        if (sourceLine.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl volumeControl = (FloatControl) sourceLine.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(volume);  // Ajustar el volumen
        }
    }

    /**
     * Detiene la reproducción en bucle.
     */
    public void stopLoop() {
        isPlaying = false;
    }
}

