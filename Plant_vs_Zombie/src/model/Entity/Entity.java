package model.Entity;

//實體抽象類； 實體:有碰撞行為的物件，如:植物、殭屍、子彈
public abstract class Entity{
	
	//行數、列數
	private int row=0, col=0;
	//xy座標
	private int x=0, y=0;
	//速度(負值向左、0不動、正值向右)
	private int speed=0;
	//生命值
	private int  health=5, max_health=5;
	//死亡後存在時間
	private int died_time=0, max_died_time=0;
	//圖像路徑
	private String name=" ";
	//碰撞箱長、寬
	private int bounding_box_width, bounding_box_height;
	//圖片路徑
	private String imgsrc;
	
	
	public Entity(String name, int row, int col) {
		set_name(name);
		set_row(row);
		set_col(col);
		set_bounding_box_height(71);
		set_bounding_box_height(71);
		set_x(250+83*col);
		set_y(90+100*row);
	}
	
	
	public int get_row() {
		return row;
	}
	
	public int get_col() {
		return col;
	}
	
	public int get_x() {
		return x;
	}
	
	public int get_y() {
		return y;
	}
	
	public int get_health() {
		return health;
	}
	
	public int get_max_health() {
		return max_health;
	}
	
	public String get_name() {
		return name;
	}
	
	public int get_bounding_box_width() {
		return bounding_box_width;
	}
	
	public int get_bounding_box_height() {
		return bounding_box_height;
	}
	
	public String get_imgsrc() {
		return imgsrc;
	}
	
	public void set_row(int row) {
		this.row=row;
	}
	
	public void set_col(int col) {
		this.col=col;
	}
	
	public void set_x(int x) {
		this.x=x;
	}
	
	public void set_y(int y) {
		this.y=y;
	}
	
	public void set_health(int h) {
		this.health = h;
	}
	
	public void set_max_health(int h) {
		this.max_health = h;
	}
	
	public boolean died_time_out() {
		this.died_time++;
		return died_time>=max_died_time;
	}
	
	public void set_max_died_time(int died_time) {
		this.max_died_time=died_time;
	}
	
	public void set_name(String s) {
		this.name=s;
	}
	
	public void set_bounding_box_width(int w) {
		this.bounding_box_width = w;
	}
	
	public void set_bounding_box_height(int h) {
		this.bounding_box_height = h;
	}
	
	public void set_imgsrc(String imgsrc) {
		this.imgsrc=imgsrc;
	}
	
	
	public void move() {
		set_x(get_x()+get_speed());
	
	}
	
	public int get_speed() {
		return speed;
	}
	
	public void set_speed(int speed) {
		this.speed=speed;
	}
	//將圖像切換為死亡
	abstract public void turn_to_die();
	
	public boolean is_alive() {
		return this.health>0;
	}
	/*test
	static public void main(String[] args) {
		Plant p = new Plant("p", 0, 0);
		Zombie z = new Zombie("z", 0, 0);
		p.set_x(100);
		z.set_x(150);
		
		System.out.println("plant: "+p.get_x()+", "+p.get_y());
		System.out.println("zombie: "+z.get_x()+", "+z.get_y());
		if(z.zombie_hit(p)) {
			System.out.println("zombit hit");
		}
		else{
			System.out.println("no hit");
		}
		if(p.plant_hit(z)) {
			System.out.println("plant hit");
		}
		else{
			System.out.println("no hit");
		}
	}
	*/
	
	
}

