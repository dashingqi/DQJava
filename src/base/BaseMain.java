package base;

import base.arithmetic.soort.DQSort;

import java.nio.charset.StandardCharsets;

/**
 * 1. Java中的char是由两个字节组成，如何存储UTF-8
 * char中的字节存储的是Unicode码点
 * Unicode是字符集 字符集包括 Unicode和ASCII 可以理解字符集是一种 一一对应的一种规则；
 * 字符到整数的映射是通过码点
 * UTF-16 最小单位是2个字节 UTF-8的最小单位是1个字节
 * Java中的char存储的是UTF-16 （有点浪费）
 * char就联想到字符串
 * Java9之前使用的是char数组进行存储char ，一个char使用两个字节存储 编码格式是UTF-16，浪费
 * Java9中对于字符串进行了优化，使用了byte数组，对于拉丁字符 使用Latin-1进行编码（一个字节就能存储下），对于中文以及其他字符超过Latin-1
 * 使用UTF-16
 * Java9中没有修复 字符数!=字符长度的bug 比如表情 一个表情的长度是2
 */
public class BaseMain {

    public static void main(String[] args) {
        char c = '张';
        // char 里面存储的是什么，打印出来的是 0x5e、0x86 是Unicode的码点
        // Unicode是字符集，字符集包括 Unicode和ASCII

        // UTF-8 最小单位是1个字节
        // UTF-16最小单位是2个字节
        // UTF-8 、 UTF-16 是编码格式

        // Java中的char存储的是 UTF-16 编码后

        System.out.println(Integer.toHexString(c));

        byte[] bytes = "张".getBytes(StandardCharsets.UTF_16);
        for (byte b : bytes) {
            System.out.println("b == " + Integer.toHexString(b));
        }
        // b == fffffffe
        // b == ffffffff
        // b == 5f
        // b == 20
        // 其中 fe 和 ff 是字节系列标志 不代表真正的内容
        System.out.println("UTF_16 byte length " + bytes.length);
        // Java9 中对与拉丁字符做了存储空间上的优化，9之前使用 char[] 数组存储，9以及之后使用 byte[] 默认是Latin-1编码也就是使用一个字节
        // 当字符串出现中文以及其他超出Latin-1 编码范围的字符的时候，这时候就使用UTF-16进行编码，默认是占2个字节的。
        System.out.println("\uD83D\uDE0A".length());
        int[] ints = {4, 3, 7, 2, 8, 10, 9};
        DQSort.quickSort(ints, 0, ints.length - 1);
    }
}


//          二进制	  十进制	十六进制	字符/缩写	解释
//        00000000	0	00	NUL (NULL)	空字符
//        00000001	1	01	SOH (Start Of Headling)	标题开始
//        00000010	2	02	STX (Start Of Text)	正文开始
//        00000011	3	03	ETX (End Of Text)	正文结束
//        00000100	4	04	EOT (End Of Transmission)	传输结束
//        00000101	5	05	ENQ (Enquiry)	请求
//        00000110	6	06	ACK (Acknowledge)	回应/响应/收到通知
//        00000111	7	07	BEL (Bell)	响铃
//        00001000	8	08	BS (Backspace)	退格
//        00001001	9	09	HT (Horizontal Tab)	水平制表符
//        00001010	10	0A	LF/NL(Line Feed/New Line)	换行键
//        00001011	11	0B	VT (Vertical Tab)	垂直制表符
//        00001100	12	0C	FF/NP (Form Feed/New Page)	换页键
//        00001101	13	0D	CR (Carriage Return)	回车键
//        00001110	14	0E	SO (Shift Out)	不用切换
//        00001111	15	0F	SI (Shift In)	启用切换
//        00010000	16	10	DLE (Data Link Escape)	数据链路转义
//        00010001	17	11	DC1/XON
//        (Device Control 1/Transmission On)	设备控制1/传输开始
//        00010010	18	12	DC2 (Device Control 2)	设备控制2
//        00010011	19	13	DC3/XOFF
//        (Device Control 3/Transmission Off)	设备控制3/传输中断
//        00010100	20	14	DC4 (Device Control 4)	设备控制4
//        00010101	21	15	NAK (Negative Acknowledge)	无响应/非正常响应/拒绝接收
//        00010110	22	16	SYN (Synchronous Idle)	同步空闲
//        00010111	23	17	ETB (End of Transmission Block)	传输块结束/块传输终止
//        00011000	24	18	CAN (Cancel)	取消
//        00011001	25	19	EM (End of Medium)	已到介质末端/介质存储已满/介质中断
//        00011010	26	1A	SUB (Substitute)	替补/替换
//        00011011	27	1B	ESC (Escape)	逃离/取消
//        00011100	28	1C	FS (File Separator)	文件分割符
//        00011101	29	1D	GS (Group Separator)	组分隔符/分组符
//        00011110	30	1E	RS (Record Separator)	记录分离符
//        00011111	31	1F	US (Unit Separator)	单元分隔符
//        00100000	32	20	(Space)	空格
//        00100001	33	21	!
//        00100010	34	22	"
//        00100011	35	23	#
//        00100100	36	24	$
//        00100101	37	25	%
//        00100110	38	26	&
//        00100111	39	27	'
//        00101000	40	28	(
//        00101001	41	29	)
//        00101010	42	2A	*
//        00101011	43	2B	+
//        00101100	44	2C	,
//        00101101	45	2D	-
//        00101110	46	2E	.
//        00101111	47	2F	/
//        00110000	48	30	0
//        00110001	49	31	1
//        00110010	50	32	2
//        00110011	51	33	3
//        00110100	52	34	4
//        00110101	53	35	5
//        00110110	54	36	6
//        00110111	55	37	7
//        00111000	56	38	8
//        00111001	57	39	9
//        00111010	58	3A	:
//        00111011	59	3B	;
//        00111100	60	3C	<
//        00111101	61	3D	=
//        00111110	62	3E	>
//        00111111	63	3F	?
//        01000000	64	40	@
//        01000001	65	41	A
//        01000010	66	42	B
//        01000011	67	43	C
//        01000100	68	44	D
//        01000101	69	45	E
//        01000110	70	46	F
//        01000111	71	47	G
//        01001000	72	48	H
//        01001001	73	49	I
//        01001010	74	4A	J
//        01001011	75	4B	K
//        01001100	76	4C	L
//        01001101	77	4D	M
//        01001110	78	4E	N
//        01001111	79	4F	O
//        01010000	80	50	P
//        01010001	81	51	Q
//        01010010	82	52	R
//        01010011	83	53	S
//        01010100	84	54	T
//        01010101	85	55	U
//        01010110	86	56	V
//        01010111	87	57	W
//        01011000	88	58	X
//        01011001	89	59	Y
//        01011010	90	5A	Z
//        01011011	91	5B	[
//        01011100	92	5C	\
//        01011101	93	5D	]
//        01011110	94	5E	^
//        01011111	95	5F	_
//        01100000	96	60	`
//        01100001	97	61	a
//        01100010	98	62	b
//        01100011	99	63	c
//        01100100	100	64	d
//        01100101	101	65	e
//        01100110	102	66	f
//        01100111	103	67	g
//        01101000	104	68	h
//        01101001	105	69	i
//        01101010	106	6A	j
//        01101011	107	6B	k
//        01101100	108	6C	l
//        01101101	109	6D	m
//        01101110	110	6E	n
//        01101111	111	6F	o
//        01110000	112	70	p
//        01110001	113	71	q
//        01110010	114	72	r
//        01110011	115	73	s
//        01110100	116	74	t
//        01110101	117	75	u
//        01110110	118	76	v
//        01110111	119	77	w
//        01111000	120	78	x
//        01111001	121	79	y
//        01111010	122	7A	z
//        01111011	123	7B	{
//        01111100	124	7C	|
//        01111101	125	7D	}
//        01111110	126	7E	~
//        01111111	127	7F	DEL (Delete)	删除
