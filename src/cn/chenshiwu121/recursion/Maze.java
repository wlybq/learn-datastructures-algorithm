package cn.chenshiwu121.recursion;


/**
 * 迷宫回溯问题
 * @author csw
 *
 */
public class Maze {
	
	public static void main(String[] args) {
		int[][] map = getMap();
//		printMap(map);
		setWay(map, 1, 1);
		printMap(map);
	}

	public static int[][] getMap() {
		int[][] map = new int[8][8];
		
		for (int i = 0; i < map.length; i++) {
			map[i][0] = 1;
			map[i][map.length-1] = 1;
		}
		
		for (int i = 0; i < map.length; i++) {
			map[0][i] = 1;
			map[map.length-1][i] = 1;
		}
		
		map[2][2] = 1;
		map[1][4] = 1;
		map[2][4] = 1;
		map[3][4] = 1;
		map[4][4] = 1;
		map[5][4] = 1;
		map[3][1] = 1;
		map[3][2] = 1;
		map[5][2] = 1;
		map[5][3] = 1;
		
		return map;
	}
	
	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][6] == 2) return true;
		else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				boolean enterAble = (
					setWay(map, i, j+1) ||
					setWay(map, i+1, j) ||
					setWay(map, i, j-1) ||
					setWay(map, i-1, j)
				);
				if (enterAble) return true;
				else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int n = map[i][j];
				System.out.print( n== 1 ? " # " : 
					(n == 2 ? " Y " : "   "));
//				System.out.printf(" %d ", map[i][j]);
			}
			System.out.println();
		}
	}
}
