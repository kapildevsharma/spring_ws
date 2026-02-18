/**
 * Find all before and after character in main string after matching sub-string
 * @author kapilsharma05
 *
 */

public class InteriorLogicInterview {

	public static void main(String[] args) {
		
		new InteriorLogicInterview().getBeforeAfterCharacter("XY12XY", "XY");
		new InteriorLogicInterview().getBeforeAfterCharacter("A13BXY13B2XKA13BW", "13B");

	}
	public String getBeforeAfterCharacter(String str, String checkStr) {
		StringBuilder strBuilder = new StringBuilder();
		if(str!=null && checkStr !=null) {
			char[] mainArr = str.toCharArray();
			char checkArr [] = checkStr.toCharArray();
			if(checkArr.length>0 && mainArr.length>0) {
				for(int i =0; i< mainArr.length; i++) {
					
					for(int j =0; j< checkArr.length; j++) {

						if(mainArr[i]== checkArr[j]) {
							if(i==0) {
								i++;
								continue;
							}
							if(i>0 && i < mainArr.length-1 && j==checkArr.length-1) {
								i++;
								strBuilder.append(mainArr[i]);
							}else if(i>0 && i< mainArr.length && j==0 ) {
								strBuilder.append(mainArr[i-1]);
								i++;
							}else if(i == mainArr.length) {
								break;
							}else {
								i++;
								continue;
							}
						}
					}
				}
			}
			System.out.println("Result: "+ strBuilder.toString());
		}else {
			System.out.println("Provide valid arguments");
		}
		return strBuilder.toString();
				
	}

}
