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
//��������ͼ
//  ����ͼ����
  String title = "���ѻ����ʶԱȷ���ͼ";
//  ����ͼX����ʾ
  String domain = "����";
//  ����ͼY����ʾ
  String range = "������";
//  ����ͼ�Ա���
  String subtitleStr = "aa";
//  ����ʱ������Դ

DefaultCategoryDataset line_dataset = new DefaultCategoryDataset();

line_dataset.addValue( 64.01, "����", "01");
line_dataset.addValue( 66.36, "����", "02");
line_dataset.addValue( 66.36, "����", "03");
line_dataset.addValue( 70.40, "����", "04");
line_dataset.addValue( 71.59, "����", "05");
line_dataset.addValue( 73.84, "����", "06");
line_dataset.addValue( 75.39, "����", "07");
line_dataset.addValue( 78.41, "����", "08");
line_dataset.addValue( 79.42, "����", "09");
line_dataset.addValue( 81.20, "����", "10");
line_dataset.addValue(80, "����", "11");
line_dataset.addValue(60, "����", "12");
line_dataset.addValue(50.5, "����", "13");

line_dataset.addValue(99, "����", "01");
line_dataset.addValue(85, "����", "02");
line_dataset.addValue(65, "����", "03");
line_dataset.addValue(45, "����", "04");
line_dataset.addValue(99, "����", "05");
line_dataset.addValue(99, "����", "06");
line_dataset.addValue(99, "����", "07");
line_dataset.addValue(99, "����", "08");
line_dataset.addValue(99, "����", "09");


//  ʱ������Ԫ��
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
 //��������۵�
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
 
 TextTitle subtitle = new TextTitle(subtitleStr, new Font("����", Font.BOLD, 12));
 line_chart.addSubtitle(subtitle);
 line_chart.setTitle(new TextTitle(title, new Font("����", Font.ITALIC, 15)));
 String line_filename = ServletUtilities.saveChartAsPNG(line_chart, 700, 400, null, session);
 String line_graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + line_filename;
 
%>
<img src="<%= line_graphURL %>" width=720 height=400 border=0 usemap="#<%= line_filename %>">
