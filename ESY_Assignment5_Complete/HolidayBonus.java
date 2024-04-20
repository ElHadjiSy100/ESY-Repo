package ESY_Assignment5_Complete;


public class HolidayBonus {
	private static final int highBonus = 5000; 
	private static final int lowBonus = 1000; 
	private static final int normBonus = 2000;
	
	
	
	/*
	 *Minnie and Mickey are getting ready to send out Holiday bonuses to their hard-working employees in Retail District #5.The bonuses are calculated based on how much each retail store sold in each category. The retail store with the highest amount sold in the category will receive $5,000. The retail store with the lowest amount sold in a category will receive $1,000. All other retail stores in district #5 will receive $2,000. If a retail store didn’t sale anything in a category, or they have a negative sales amount, they are not eligible for a bonus in that category. If only one retail store sold items in a category, they are eligible to receive only the bonus of $5000 for that category.
	 */
	public static double[] calculateHolidayBonus(double[][] data){
		int numCols = 0;
		for(int i = 0; i < data.length; i++) {
			if(data[i].length > numCols) {
				numCols = data[i].length;
			}
		}
		double[] bonus = new double[data.length];
		
		for(int i = 0; i < numCols; i++) {
			int highestRow = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			int lowestRow = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			bonus[highestRow] += highBonus;
			bonus[lowestRow] += lowBonus;
			for(int j = 0; j < data.length; j++) {
				if(j != highestRow && j != lowestRow && i < data[j].length) {
					bonus[j] += normBonus;
				}
			}
		}
		
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double [][] data){
		double bonusTotal = 0.0;
		double [] bonus = calculateHolidayBonus(data);
		for(int i = 0; i < bonus.length; i++) {
			bonusTotal += bonus[i];
		}
		return bonusTotal;
	}
}
