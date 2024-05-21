javac -cp src/main/java src/main/java/com/blitzhetz/*.java

if ($LastExitCode -eq 0) {
    java -cp src/main/java com.blitzhetz.Main
} else {
    Write-Host "Compilation failed, what is wrong with you bruhh"
}