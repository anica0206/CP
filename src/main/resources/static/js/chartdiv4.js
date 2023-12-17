
  am5.ready(function() {

// Create root element
// https://www.amcharts.com/docs/v5/getting-started/#Root_element
  var root = am5.Root.new("chartdiv4");

// Set themes
// https://www.amcharts.com/docs/v5/concepts/themes/
  root.setThemes([
  am5themes_Animated.new(root)
  ]);

// Create chart
// https://www.amcharts.com/docs/v5/charts/xy-chart/
  var chart = root.container.children.push(am5xy.XYChart.new(root, {
  panX: false,
  panY: false,
  wheelX: "none",
  wheelY: "none",
  paddingLeft: 0
}));

// Add cursor
// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
  var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {}));
  cursor.lineY.set("visible", false);

// Create axes
// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
  var xRenderer = am5xy.AxisRendererX.new(root, {
  minGridDistance: 30,
  minorGridEnabled: true
});

  var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
  maxDeviation: 0,
  categoryField: "name",
  renderer: xRenderer,
  tooltip: am5.Tooltip.new(root, {})
}));

  xRenderer.grid.template.set("visible", false);

  var yRenderer = am5xy.AxisRendererY.new(root, {});
  var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
  min: 0,
  max: 100,
  numberFormat: "#'%'",
  renderer: yRenderer
}));

  yRenderer.grid.template.setAll({
  strokeDasharray: [2, 2]
});

// Create series
// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
  var series = chart.series.push(am5xy.ColumnSeries.new(root, {
  name: "Series 1",
  xAxis: xAxis,
  yAxis: yAxis,
  valueYField: "value",
  sequencedInterpolation: true,
  categoryXField: "name",
  tooltip: am5.Tooltip.new(root, { dy: -25, labelText: "{valueY}" })
}));


  series.columns.template.setAll({
  cornerRadiusTL: 5,
  cornerRadiusTR: 5,
  strokeOpacity: 0
});

  series.columns.template.adapters.add("fill", (fill, target) => {
  return chart.get("colors").getIndex(series.columns.indexOf(target));
});

  series.columns.template.adapters.add("stroke", (stroke, target) => {
  return chart.get("colors").getIndex(series.columns.indexOf(target));
});

// Set data
  var data = [
{
  name: "2018",
  value: 82.9
},
{
  name: "2019",
  value: 86
},
{
  name: "2020",
  value: 86.8
},
{
  name: "2021",
  value: 89.1
},
{
  name: "2022",
  value: 92.4
}
  ];


  xAxis.data.setAll(data);
  series.data.setAll(data);

// Make stuff animate on load
// https://www.amcharts.com/docs/v5/concepts/animations/
  series.appear(1000);
  chart.appear(1000, 100);

}); // end am5.ready()
