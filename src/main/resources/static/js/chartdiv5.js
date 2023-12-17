
  am5.ready(function() {

// Create root element
// https://www.amcharts.com/docs/v5/getting-started/#Root_element
  var root = am5.Root.new("chartdiv5");


// Set themes
// https://www.amcharts.com/docs/v5/concepts/themes/
  root.setThemes([
  am5themes_Animated.new(root)
  ]);


// Create chart
// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
  var chart = root.container.children.push(am5percent.PieChart.new(root, {
  layout: root.verticalLayout,
  innerRadius: am5.percent(50),
    Radius: am5.percent(100)
}));


// Create series
// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
  var series = chart.series.push(am5percent.PieSeries.new(root, {
  valueField: "value",
  categoryField: "category",
  alignLabels: false,
  disable: true
  }));

  series.labels.template.setAll({
  textType: "circular",
  centerX: 0,
  centerY: 0
});


// Set data
// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
  series.data.setAll([
    { value: 10, category: "빅데이터" },
    // { value: 1, category: "게임개발" },
    { value: 6, category: "secure coding" },
    { value: 9, category: "AI" },
    // { value: 3, category: "정보처리기사" },
    { value: 5, category: "APP" },
    { value: 5, category: "AWS" },
    { value: 3, category: "C/C++" },
    { value: 4, category: "IoT" },
    { value: 30, category: "Java" },
    { value: 1, category: "Node.js" },
    { value: 1, category: "Linux" },
    { value: 17, category: "Python" },
    { value: 5, category: "React" },
    { value: 3, category: "Spring" },
    { value: 3, category: "SQL" },
    // { value: 1, category: "SWIFT" },
    { value: 11, category: "UIUX" },
    { value: 13, category: "WEB" }
  ]);
    series.labels.template.set("visible", false);
    series.ticks.template.set("visible", false);

// Create legend
// https://www.amcharts.com/docs/v5/charts/percent-charts/legend-percent-series/
  var legend = chart.children.push(am5.Legend.new(root, {
  centerX: am5.percent(50),
  x: am5.percent(50),
  marginTop: 15,
  marginBottom: 15,
}));
    legend.data.setAll(series.dataItems);  //범례 크기
    legend.markers.template.setAll({
      width: 10,
      height: 10
    });

    legend.labels.template.setAll({   //범례 폰트 크기
      fontSize: 10,
      fontWeight: "500"
    });
    legend.valueLabels.template.setAll({
      fontSize: 10,
      fontWeight: "500"
    });


// Play initial series animation
// https://www.amcharts.com/docs/v5/concepts/animations/#Animation_of_series
  series.appear(1000, 100);

}); // end am5.ready()
