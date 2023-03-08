package Helpers;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class ProgressBarLoader {

    private JProgressBar progressBar;
    private int startPercentage;
    private int endPercentage;

    public ProgressBarLoader(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void startLoading(int startPercentage, int endPercentage, Runnable onComplete) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                int progress = startPercentage;
                while (progress < endPercentage) {
                    // Sleep for 10 milliseconds to simulate loading time
                    Thread.sleep(10);
                    progress++;
                    progressBar.setValue(progress);
                }
                return null;
            }

            @Override
            protected void done() {
                // Call the onComplete callback on the main thread once the loading is complete
                SwingUtilities.invokeLater(onComplete);
            }
        };

        worker.execute();
    }
}


