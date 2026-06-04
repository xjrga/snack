#!/bin/bash

script_path=$(pwd)

echo "Please choose a file to compile and run:"

select filename in $(ls snack*.{lp,c,rs,java,R} 2>/dev/null) "Quit Loop" "Clean"; do
    case "$filename" in
        "Quit Loop")
            echo "-----------------"
            echo "Have a great day!"
            echo "-----------------"
            break
            ;;
        "Clean")
            echo "---------------------------------"
            echo "All snack models will be deleted."
            echo "---------------------------------"
            read -p "Are you sure? " -n 1 -r
            echo ""
            if [[ $REPLY =~ ^[Yy]$ ]]; then
                rm -v snack*.{lp,c,rs,java,R,o} 2>/dev/null
                rm -v TestSnack.{java,class} 2>/dev/null
            fi
            break
            ;;
        "")
            echo "Invalid selection. Try again."
            ;;
        *)
            extension="${filename##*.}"
            basename="${filename%.*}"
            case "$extension" in
                c)
                    echo "$filename"
                    export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/lib/lp_solve:/usr/lib/lp_solve
                    #clang-format -i $filename
                    gcc $filename -I/usr/include/lpsolve -L/usr/lib/lp_solve -o "${basename}.o" -llpsolve55
                    ./"${basename}.o"
                    ;;
                rs)
                    echo "$filename"
                    cp $filename snack/src/main.rs
                    cd snack/src/
                    #rustfmt main.rs
                    cargo build
                    cargo run
                    cd "$script_path"
                    ;;
                java)
                    echo "$filename"
                    cp $filename TestSnack.java
                    javac -cp "../lib/commons-math3-3.6.1.jar" TestSnack.java
                    java -cp "./:../lib/commons-math3-3.6.1.jar" TestSnack
                    ;;
                R)
                    echo "$filename"
                    R <$filename --no-save
                    ;;
                lp)
                    echo "$filename"
                    lp_solve -S3 $filename
                    ;;
            esac
            ;;
    esac
done
