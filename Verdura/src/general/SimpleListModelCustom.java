package general;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.SimpleListModel;

public class SimpleListModelCustom<E> extends SimpleListModel<Object> {

	private static final long serialVersionUID = 1L;

	public SimpleListModelCustom(List<?> data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ListModel<Object> getSubModel(Object value, int nRows) {
		final String idx = value == null ? "" : value.toString();
		final LinkedList<Object> data = new LinkedList<Object>();
		for (int i = 0; i < getSize(); i++) {
			if (inSubModel(getElementAt(i).toString(), idx)) {
				data.add(getElementAt(i));
			}
		}
		return new SimpleListModelCustom<Object>(data);
	}

	private boolean inSubModel(String element, String text) {
		if (text.length() != 0)
			return element.toLowerCase().indexOf(text.toLowerCase()) != -1 ? true : false;
		else
			return false;
	}
}