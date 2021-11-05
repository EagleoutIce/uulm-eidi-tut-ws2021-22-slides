import java.util.Arrays;

public class MemberBase {
  private final Member[] members;

  public MemberBase(Member... members) {
    this.members = Arrays.copyOf(members, members.length);
    sortBase();
  }

  private void sortBase() {
    for (int n = this.members.length; n > 1; n--) {
      for (int i = 0; i < n-1; i++) {
        if (this.members[i].compareTo(this.members[i+1]) > 0) {
          Member tmp = this.members[i];
          this.members[i] = this.members[i+1];
          this.members[i+1] = tmp;
        }
      }
    }
  }

  public boolean find(Member member) {
    int left = 0;
    int right = this.members.length - 1;

    while (left <= right) {
      int mid = left + (right-left)/2;
      if (member.compareTo(members[mid]) < 0) {
        right = mid - 1;
      } else if(member.compareTo(members[mid]) > 0) {
        left = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
