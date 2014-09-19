SELECT
	o.id_order_number,
	od.id_item,
	od.item_name,
	/*od.quantity,
	im.weight_unit*/
	SUM(od.quantity * im.weight_unit)
FROM
	torder o INNER JOIN torder_detail od ON o.id_order = od.id_order
	INNER JOIN titem i ON i.id_item = od.id_item
	INNER JOIN tinput_measure_unit im ON (im.id_item = i.id_item AND im.measure_unit = od.measure_unit)
WHERE
	o.id_order_number = 4
GROUP BY od.id_item, od.item_name, o.id_order_number
