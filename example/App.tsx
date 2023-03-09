import * as Settings from "expo-settings";
import { Pressable, Text, View, StyleSheet } from "react-native";

export default function App() {
  return (
    <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
      <Pressable
        style={styles.button}
        onPress={() => Settings.startDummyActivity()}
      >
        <Text>start dummy activity</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  button: {
    marginTop: 8,
    padding: 16,
    backgroundColor: "red",
    borderRadius: 8,
  },
});
