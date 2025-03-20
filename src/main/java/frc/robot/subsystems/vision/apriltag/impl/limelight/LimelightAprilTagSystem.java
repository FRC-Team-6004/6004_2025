/*package frc.robot.subsystems.vision.apriltag.impl.limelight;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.vision.apriltag.AprilTagDetection;
import frc.robot.subsystems.vision.apriltag.AprilTagPose;
import frc.robot.subsystems.vision.apriltag.AprilTagResults;
import frc.robot.subsystems.vision.apriltag.AprilTagSubsystem;
import frc.robot.subsystems.vision.util.LimelightHelpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Logged
public class LimelightAprilTagSystem extends SubsystemBase implements AprilTagSubsystem {
    private final CommandSwerveDrivetrain commandSwerveDrivetrain;
    private final String limelightName;
    private AprilTagResults aprilTagResults;
    private LimelightHelpers.PoseEstimate poseEstimate;

    private LimelightHelpers.LimelightTarget_Fiducial currentBestDetection;
    private double currentBestDetectionDistance = Double.POSITIVE_INFINITY;

    public LimelightAprilTagSystem(
            String limelightName, CommandSwerveDrivetrain commandSwerveDrivetrain) {
        this.commandSwerveDrivetrain = commandSwerveDrivetrain;
        this.limelightName = limelightName;
    }

    @Override
    public void periodic() {
        currentBestDetection = null;
        currentBestDetectionDistance = Double.POSITIVE_INFINITY;

        double yaw = commandSwerveDrivetrain.getRotation3d().getAngle();
        LimelightHelpers.SetRobotOrientation(limelightName, yaw, 0, 0, 0, 0, 0);
        poseEstimate = LimelightHelpers.getBotPoseEstimate_wpiBlue(limelightName);
        LimelightHelpers.LimelightResults results =
                LimelightHelpers.getLatestResults(limelightName);

        if (!results.valid) {
            return;
        }

        List<AprilTagDetection> aprilTagDetections =
                new ArrayList<>(results.targets_Fiducials.length);

        for (LimelightHelpers.LimelightTarget_Fiducial aprilTag : results.targets_Fiducials) {
            double normDistance = aprilTag.getCameraPose_TargetSpace2D().getTranslation().getNorm();

            if (normDistance < currentBestDetectionDistance) {
                currentBestDetection = aprilTag;
                currentBestDetectionDistance = normDistance;
            }

            aprilTagDetections.add(mapToDetection(aprilTag));
        }

        aprilTagResults =
                new AprilTagResults(
                        results.timestamp_LIMELIGHT_publish,
                        results.latency_pipeline,
                        aprilTagDetections);
    }

    @Override
    public Optional<AprilTagResults> getResults() {
        return Optional.ofNullable(aprilTagResults);
    }

    @Override
    public Optional<AprilTagPose> getEstimatedPose() {
        return Optional.ofNullable(poseEstimate)
                .map(e -> new AprilTagPose(e.pose, e.tagCount, e.timestampSeconds));
    }

    @Override
    public Optional<AprilTagDetection> getBestDetection() {
        return Optional.ofNullable(currentBestDetection).map(this::mapToDetection);
    }

    //
    //    @Logged(name = "targetPoses")
    //    public List<Pose2d> getLimelightTargetPose() {
    //        return
    // aprilTagResults.getResults().stream().map(AprilTagDetection::getTargetPose).toList();
    //    }
    //
    //    @Logged(name = "robotPoses")
    //    public List<Pose2d> getRobotPose() {
    //        return
    // aprilTagResults.getResults().stream().map(AprilTagDetection::getRobotPose).toList();
    //    }
    //
    //    @Logged(name = "estimatedRobotPose")
    //    public Pose2d getEstimateRobotPose() {
    //        return poseEstimate.pose;
    //    }

    @Logged(name = "Detection translation")
    public Translation2d bestDetectionTranslatedPosePose() {
        return getBestDetection()
                .map(p -> p.getTargetPose().getTranslation())
                .orElse(new Translation2d());
    }

    private AprilTagDetection mapToDetection(LimelightHelpers.LimelightTarget_Fiducial aprilTag) {
        return new AprilTagDetection(
                (int) aprilTag.fiducialID,
                aprilTag.getRobotPose_FieldSpace2D(),
                aprilTag.getTargetPose_RobotSpace2D(),
                0 // we can trust MegaTag2, as it eliminates pose ambiguity
                );
    }
}
*/