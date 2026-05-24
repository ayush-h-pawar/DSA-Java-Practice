import java.util.*;

public class FlattenNestedListIterator
        implements Iterator<Integer> {

    interface NestedInteger {

        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    Stack<Iterator<NestedInteger>> stack;

    Integer nextVal;

    public FlattenNestedListIterator(
            List<NestedInteger> nestedList) {

        stack = new Stack<>();

        stack.push(nestedList.iterator());
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty()) {

            Iterator<NestedInteger> itr =
                    stack.peek();

            if (!itr.hasNext()) {

                stack.pop();
                continue;
            }

            NestedInteger ni =
                    itr.next();

            if (ni.isInteger()) {

                nextVal =
                        ni.getInteger();

                return true;

            } else {

                stack.push(
                        ni.getList()
                          .iterator()
                );
            }
        }

        return false;
    }

    @Override
    public Integer next() {

        return nextVal;
    }
        }
