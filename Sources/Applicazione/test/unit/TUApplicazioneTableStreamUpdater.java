/*
* Name: TUApplicazioneTableStreamUpdater.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-24
* Version: v1.00
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Dal Bianco Davide Verify
* =================================================================
* v0.01 2015-05-24  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.ChartUpdater;
import it.kaizenteam.app.model.NorrisChart.TableStreamUpdater;


public class TUApplicazioneTableStreamUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        ChartUpdater a = TableStreamUpdater.getInstance();
        ChartUpdater b = TableStreamUpdater.getInstance();
    }
}