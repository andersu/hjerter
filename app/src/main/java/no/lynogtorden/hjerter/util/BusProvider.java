package no.lynogtorden.hjerter.util;

import com.squareup.otto.Bus;

import android.os.Handler;
import android.os.Looper;

import no.lynogtorden.hjerter.event.Event;


public class BusProvider {

    private static final Bus BUS = new Bus();
    private final static Handler handler = new Handler(Looper.getMainLooper());

    private BusProvider() {

    }

    public static Bus getInstance() {
        return BUS;
    }

    public static void updateUi(final Event baseEvent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            BUS.post(baseEvent);
        }
        else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    BUS.post(baseEvent);
                }
            });
        }
    }
}
