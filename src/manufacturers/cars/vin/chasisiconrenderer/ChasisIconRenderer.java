/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manufacturers.cars.vin.chasisiconrenderer;

/**
 *
 * @author dobri
 */
public class ChasisIconRenderer {

    private static ChasisIconRenderer instance;

    private ChasisIconRenderer() {
    }

    public static ChasisIconRenderer getDefault() {
        return (instance == null
                ? instance = new ChasisIconRenderer()
                : instance);
    }

    public void generateIcons(String ChasisID, INodeIconRenderer iNodeIconRenderer) {
        switch (ChasisID) {
            case "WVW":
            case "WV1":
            case "WV2":
            case "WVG":
            case "1VW":
            case "3VW":
            case "9BW":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/vw.24x24.jpg");
                break;
            case "WAU":
            case "TRUE":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/audi.24x24.jpg");
                break;
            case "SB1":
            case "VNK":
            case "VAN":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/toyota24x24.gif");
                break;
            case "4US":
            case "WBA":
            case "WBS":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/bmw.24x24.jpg");
                break;
            case "VSS":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/seat.24x24.gif");
                break;
            case "TMB":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/skoda_logo2.24x24.jpg");
                break;
            case "VX1":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/fiat.24x24.jpg");
                break;
            case "VF3":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/peugeot.24x24.jpg");
                break;
            case "VF1":
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/automobili/brands/Renault.16x16.jpg");
                break;
            default:
                iNodeIconRenderer.node_setIconBaseWithExtension("ikonice/auto.16x16.jpg");
        }
    }
}
