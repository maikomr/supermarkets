package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphPanelMouseListener implements MouseListener {

	private MainController ctrl;

	public GraphPanelMouseListener(MainController ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (ctrl.getCurrentAction()) {
		case NEW_NODE:
			ctrl.createNewNode(e.getPoint());
			break;
		default:
			break;
		}
		ctrl.setCurrentAction(Action.NONE);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
