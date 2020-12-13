<%@ page contentType="text/html;charset=GBK"%>
<%@ page import =" java.awt.*,
java.text.SimpleDateFormat,
javax.swing.JPanel,
org.jfree.chart.axis.DateAxis,
org.jfree.chart.plot.XYPlot,
org.jfree.chart.renderer.xy.XYItemRenderer,
org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,
org.jfree.chart.ChartPanel,
org.jfree.data.xy.XYDataset,
org.jfree.chart.ChartFactory,
org.jfree.chart.JFreeChart,
org.jfree.chart.title.TextTitle,
org.jfree.chart.plot.*,
org.jfree.chart.renderer.xy.*,
org.jfree.chart.labels.*,
org.jfree.ui.*,
org.jfree.chart.servlet.ServletUtilities,
org.jfree.data.category.DefaultCategoryDataset,
org.jfree.chart.renderer.category.LineAndShapeRenderer"%>
<%
//生成曲线图
//  曲线图标题
  String title = "话费回收率对比分析图";
//  曲线图X轴提示
  String domain = "日期";
//  曲线图Y轴提示
  String range = "回收率";
//  曲线图自标题
  String subtitleStr = "aa";
//  创建时间数据源

DefaultCategoryDataset line_dataset = new DefaultCategoryDataset();

line_dataset.addValue( 64.01, "上月", "01");
line_dataset.addValue( 66.36, "上月", "02");
line_dataset.addValue( 66.36, "上月", "03");
line_dataset.addValue( 70.40, "上月", "04");
line_dataset.addValue( 71.59, "上月", "05");
line_dataset.addValue( 73.84, "上月", "06");
line_dataset.addValue( 75.39, "上月", "07");
line_dataset.addValue( 78.41, "上月", "08");
line_dataset.addValue( 79.42, "上月", "09");
line_dataset.addValue( 81.20, "上月", "10");
line_dataset.addValue(80, "上月", "11");
line_dataset.addValue(60, "上月", "12");
line_dataset.addValue(50.5, "上月", "13");

line_dataset.addValue(99, "当月", "01");
line_dataset.addValue(85, "当月", "02");
line_dataset.addValue(65, "当月", "03");
line_dataset.addValue(45, "当月", "04");
line_dataset.addValue(99, "当月", "05");
line_dataset.addValue(99, "当月", "06");
line_dataset.addValue(99, "当月", "07");
line_dataset.addValue(99, "当月", "08");
line_dataset.addValue(99, "当月", "09");


//  时间曲线元素
  JFreeChart line_chart =
   ChartFactory.createLineChart(
   title,
   domain,
   range,
   line_dataset,
   PlotOrientation.VERTICAL,
   true,
   true,
   false);

   //line_chart.setBackgroundPaint(Color.pink);
 //添加折线折点
 CategoryPlot plot = line_chart.getCategoryPlot();
 LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();
 renderer.setShapesVisible(true);
 renderer.setDrawOutlines(true);
 renderer.setUseFillPaint(true);
 renderer.setFillPaint(java.awt.Color.blue);
 renderer.setItemLabelsVisible(true);
 renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());        
 renderer.setBaseItemLabelFont(new Font("Dialog", 1, 10));               
 plot.setDomainGridlinePaint(Color.pink);
 plot.setRangeGridlinePaint(Color.pink);
 
 TextTitle subtitle = new TextTitle(subtitleStr, new Font("黑体", Font.BOLD, 12));
 line_chart.addSubtitle(subtitle);
 line_chart.setTitle(new TextTitle(title, new Font("隶书", Font.ITALIC, 15)));
 String line_filename = ServletUtilities.saveChartAsPNG(line_chart, 700, 400, null, session);
 String line_graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + line_filename;
 
%>
<img src="<%= line_graphURL %>" width=720 height=400 border=0 usemap="#<%= line_filename %>">
