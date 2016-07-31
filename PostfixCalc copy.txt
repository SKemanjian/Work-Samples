//
//  ShahanKemanjianAssignment2.cpp
//  
//
//  Created by Shahan Kemanjian on 5/7/15.
//
//

#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <iomanip>
#include <string>
#include <sstream>
#include <stack>

using namespace std;

void Eval(char op);
string toString(double var);

class Stack {
    
private:
    int MAX;
    int top;
    double* stck;
    
public:
    Stack(int size){
        MAX = size;
        top = -1;
        stck = new double[MAX];
    }
    
    
    void push(double x){
        if(full()){
            cout << "Stack is full" << endl;
        }
        stck[++top] = x;
    }
    
    double pop(){
        /*if(empty()) {
         cout << "Stack is Empty" << endl;
         }*/
        return stck[top--];
    }
    
    double empty(){
        return top == -1;
    }
    
    double full(){
        return top + 1 == MAX;
    }
};

Stack stck(20) ;


int main() {
    double result;
    string Endresult;
    char str[1000], digit[15];
    int i, j, k;
    double op1, op2, len, x, var, var2;
    string turn, var3 = "";
    char let, let2, let3, oper;
    printf("Please Enter your Postfix command(use spaces), press 0 to end program: \n");
    fgets (str, 1000, stdin);
    len = strlen(str);
    j = 0;
    while(str[0] != '0'){
        k = len - 2;
        if((str[0] == 'O' && str[1] == 'U' && str[2] == 'T') && (str[4] == let)){
            cout << var << endl;
        }else if ((str[0] == 'O' && str[1] == 'U' && str[2] == 'T') && (str[4] == let2)) {
            cout << var2 << endl;
        }else if ((str[0] == 'O' && str[1] == 'U' && str[2] == 'T') && str[4] == let3) {
            cout << Endresult << endl;
            
        }
        for(i=0; i<len;i++){
            if(str[i]>='0' && str[i]<='9'){
                digit[j++] = str[i];
            }
            else if(str[i]==' '){
                if(j>0){
                    digit[j] = '\0';
                    x = atof(digit);
                    stck.push(x);
                    j = 0;
                }
            }
            else if(str[i]=='.'){
                digit[j++] = str[i];
            }
            else if(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/'){
                oper = str[i];
                Eval(oper);
            }
            
            else if ((str[i] >= 65 && str[i] <= 90) && str[i+2] == '"'){
                let3 = str[0];
                int l;
                l = 3;
                while(str[l] != '"'){
                    var3 += str[l];
                    l++;
                }
                for(j = l; j < len; j++){
                    if(str[j] == let && str[j+2] == '@'){
                        turn = toString(var);
                        var3 += turn;
                        Endresult = var3;
                    }else if(str[j] == let2 && str[j+2] == '@'){
                        turn = toString(var2);
                        var3 += turn;
                        Endresult = var3;
                    }else if(str[j] == '#') {
                        int turnNum = atof(str);
                    }else if(str[j] == '+')
                        j++;
                }
                
                
            } else if ((str[i] >= 65 && str[i] <= 90) && (str[i+2] == let)) {
                var2 = str[i];
                let2 = (char)var2;
                i = i + 3;
                stck.push(var);
            }
            
            else if (str[i] >= 65 && str[i] <= 90) {
                var = str[i];
                let = (char)var;
            }
            else if (str[i] == '=' && str[0] == var2) {
                var2 = stck.pop();
            }
            else if (str[i] == '=' && str[0] == var) {
                var = stck.pop();
            }
        }
        
        
        fgets (str, 1000, stdin);
        len = strlen(str);
    }
}

void Eval(char op){
    double res1, res2, num, result;
    switch(op){
        case '+' :
            res2 = stck.pop();
            res1 = stck.pop();
            res1 = res1 + res2;
            stck.push(res1);
            break;
        case '-' :
            res2 = stck.pop();
            res1 = stck.pop();
            res1 = res1 - res2;
            stck.push(res1);
            break;
        case '*' :
            res2 = stck.pop();
            res1 = stck.pop();
            res1 = res1 * res2;
            stck.push(res1);
            break;
        case '/' :
            res2 = stck.pop();
            res1 = stck.pop();
            res1 = res1 / res2;
            stck.push(res1);
            break;
        default:
            break;
            
    }
    
}

string toString(double var) {
    ostringstream strs;
    strs << var;
    string str = strs.str();
    return str;
}